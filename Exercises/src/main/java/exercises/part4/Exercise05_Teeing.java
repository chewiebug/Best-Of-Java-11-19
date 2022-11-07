package exercises.part4;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.teeing;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise05_Teeing 
{
	public static void main(String[] args) throws IOException 
	{
		var names = Stream.of("Michael", "Tim", "Tom", "Mike", "Bernd");
		
		final Predicate<String> startsWithMi = text -> text.startsWith("Mi");
				
		final Predicate<String> isShort = text -> text.length() <= 4;
		
		final BiFunction<List<String>, List<String>, 
		                 List<List<String>>> combineResults = (list1, list2) -> List.of(list1, list2);
		
		final BiFunction<List<String>, List<String>, 
		                 Set<String>> combineResultsUnique = (list1, list2) -> 
						 {
		                	 Set<String> result = new HashSet<>(list1); 
		                	 result.addAll(list2);
		                	 return result;
		                 };   
		final BiFunction<List<String>, List<String>, 
		                 Set<String>> combineResultsIntersection = (list1, list2) -> 
						 {
		                	 Set<String> result = new HashSet<>(list1); 
		                	 result.retainAll(list2);
		                	 return result;
		                 };  		                 
		                 
		var result = names.collect(teeing(
				          filtering(startsWithMi, toList()),
            		      filtering(isShort, toList()),
            		      combineResults));
		
		System.out.println(result); 
	}
}
