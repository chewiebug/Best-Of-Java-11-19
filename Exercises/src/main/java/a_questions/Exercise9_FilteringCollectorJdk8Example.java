package a_questions;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise9_FilteringCollectorJdk8Example 
{
	public static void main(final String[] args) 
	{
		final List<String> programming = List.of("Java", "JavaScript", "Groovy", "JavaFX", "Spring", "Java");
		
		final Stream<String> programmming1 = programming.stream();	
		final Set<String> result1 = programmming1.collect(Exercise9_CollectorsUtils.filtering(name -> name.contains("Java"), toSet()));
		System.out.println(result1);
		
		final Stream<String> programmming2 = programming.stream();	
		final Map<String, Long> result2 = programmming2.collect(groupingBy(i -> i, 
				Exercise9_CollectorsUtils.filtering(name -> name.contains("Java"), counting())));		
				
		System.out.println(result2);	

	}
}
