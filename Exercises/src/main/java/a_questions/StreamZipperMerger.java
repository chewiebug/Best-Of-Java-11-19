package a_questions;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Spliterators.AbstractSpliterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class StreamZipperMerger {

	public static void main(String[] args) {

		List<String> names = List.of("Peter", "Michael", "Tim", "XXX");
		List<Integer> ages = List.of(65, 47, 42);

		Stream<Person> combined = zipLists(names, ages, Person::new);
        System.out.println("zipLists");
		combined.forEach(System.out::println);

		Stream<String> namesStream = Stream.of("Peter", "Michael", "Tim");
		Stream<Integer> agesStream = Stream.of(65, 47, 42, -1);

		Stream<Person> combinedStream = zip(namesStream, agesStream, Person::new);
        System.out.println("zip");
		combinedStream.forEach(System.out::println);
		
		Stream<String> namesStream2 = Stream.of("Peter", "Michael", "Tim", "No Age");
		Stream<Integer> agesStream2 = Stream.of(65, 47, 42);

		Stream<Person> combinedStream2 = zipShort(namesStream2, agesStream2, Person::new);		
		System.out.println("zipShort");
		combinedStream2.forEach(System.out::println);
	}

	static class Person {
		String name;
		int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		// @Vogella: Wieso macht das nicht toString() im Editor
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}

	static <A, B, C> Stream<C> zipLists(List<A> lista, List<B> listb, BiFunction<A, B, C> zipFunction) 
	{
		int shortestLength = Math.min(lista.size(), listb.size());

		return IntStream.range(0, shortestLength).mapToObj(i -> 
		{
			return zipFunction.apply(lista.get(i), listb.get(i));
		});
	}
	
	// https://stackoverflow.com/questions/17640754/zipping-streams-using-jdk8-with-lambda-java-util-stream-streams-zip
	public static <A, B, C> Stream<C> zip(Stream<? extends A> firstStream, Stream<? extends B> secondStream,
			BiFunction<? super A, ? super B, ? extends C> zipFunction) 
	{
		Spliterator<? extends A> firstSpliterator = firstStream.spliterator();
		Spliterator<? extends B> secondSpliterator = secondStream.spliterator();

		// Zipping looses DISTINCT and SORTED characteristics, könnte ja jetzt ungeordnet sein, da 
		// kombinirtes Objekt andere Reihenfolge besitzt, 
		int commonCharacteristics = firstSpliterator.characteristics() & secondSpliterator.characteristics()
				& ~(Spliterator.DISTINCT | Spliterator.SORTED);

		long maxCommonSize = Math.min(firstSpliterator.getExactSizeIfKnown(), secondSpliterator.getExactSizeIfKnown());

		// Aus den Spiterator den Iterator zurückgewinnen
		Iterator<C> cIterator = new Iterator<>() {
			
			private final Iterator<A> aIterator = Spliterators.iterator(firstSpliterator);
			private final Iterator<B> bIterator = Spliterators.iterator(secondSpliterator);

			@Override
			public boolean hasNext() 
			{
				return aIterator.hasNext() && bIterator.hasNext();
			}

			@Override
			public C next() {
				return zipFunction.apply(aIterator.next(), bIterator.next());
			}
		};

		// Erzeugt einen Spliterator basirten auf einem Iterator 
		Spliterator<C> zipSpliterator = Spliterators.spliterator(cIterator, maxCommonSize, commonCharacteristics);		
		boolean useParallel = firstStream.isParallel() || secondStream.isParallel();		
		
		return StreamSupport.stream(zipSpliterator, useParallel);
	}
	
	public static <L, R, T> Stream<T> zipShort(Stream<L> firstStream, Stream<R> secondStream, BiFunction<L, R, T> zipFunction) 
	{
		Spliterator<? extends L> firstSpliterator = firstStream.spliterator();
		Spliterator<? extends R> secondSpliterator = secondStream.spliterator();

		// Zipping looses DISTINCT and SORTED characteristics, könnte ja jetzt ungeordnet sein, da 
		// kombinirtes Objekt andere Reihenfolge besitzt, 
		int commonCharacteristics = firstSpliterator.characteristics() & secondSpliterator.characteristics()
				& ~(Spliterator.DISTINCT | Spliterator.SORTED);

		long maxCommonSize = Math.min(firstSpliterator.getExactSizeIfKnown(), secondSpliterator.getExactSizeIfKnown());


	    boolean useParallel = firstStream.isParallel() || secondStream.isParallel();
	    
	    // Her ist es mit DISTINCT und SORTED vielleicht falsch!
	    return StreamSupport.stream(new AbstractSpliterator<T>(maxCommonSize, commonCharacteristics) 
	    {
	        @Override
	        public boolean tryAdvance(Consumer<? super T> action) 
	        {
	        	// Verwirrend Consumer in Consumer
	        	// Wenn im Stream A noch ein Element, wenn dnn in Stream B auch noch ein Element ist, 
	        	// dann wird die accept- des Consumers aufgerufen, der wiederum die Elemente zusammenfügt
	            return firstSpliterator.tryAdvance(leftValue -> secondSpliterator.tryAdvance(rightValue -> action.accept(zipFunction.apply(leftValue, rightValue))));
	        }
	    }, useParallel);
	}
}
