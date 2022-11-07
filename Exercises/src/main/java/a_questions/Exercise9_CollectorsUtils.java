package a_questions;

import java.util.function.Predicate;
import java.util.stream.Collector;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise9_CollectorsUtils 
{
	public static <T, A, R> Collector<T, A, R> filtering(final Predicate<? super T> filter, 
			                                             final Collector<T, A, R> collector) 
	{
		  return Collector.of(
		      collector.supplier(),
		      
		      // TRICK
		      (accumulator, input) -> {
		         if (filter.test(input)) {
		            collector.accumulator().accept(accumulator, input);
		         }
		      },		      
		      
		      collector.combiner(),
		      collector.finisher());
	}
}
