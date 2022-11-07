package solutions.part1;

import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise03_StreamExample 
{	
	public static void main(String[] args) 
	{
		final Stream<String> values1 = Stream.of("a", "b", "c", "", "e", "f"); 
		final Stream<Integer> values2 = Stream.of(1, 2, 3, 11, 22, 33, 7, 10);

		System.out.println("takeWhile:");
        values1.takeWhile(s -> !s.isEmpty()).
                forEach(System.out::println);
 
        System.out.println("\ndropWhile:");
        values2.dropWhile(value -> value < 10).
                forEach(System.out::println);
             
        System.out.println("\nfilter try 1:");
        final Stream<Integer> values3 = Stream.of(1, 2, 3, 11, 22, 33, 7, 10);
        values3.filter(value -> value < 10).
                forEach(System.out::println);

        System.out.println("\nfilter try 2:");
        final Stream<Integer> values4 = Stream.of(1, 2, 3, 11, 22, 33, 7, 10);
        values4.filter(value -> value >= 10).
                forEach(System.out::println);
	}
}
