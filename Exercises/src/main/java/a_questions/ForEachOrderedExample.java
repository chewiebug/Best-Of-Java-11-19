package a_questions;

import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class ForEachOrderedExample {

	public static void main(String[] args) {
		
		Stream<String> names = Stream.of("Tim", "Tom", "John", "Jim", "Peter", "Mike", "Andi", "Merten", "Sebastian");
		
		// names.forEach(System.out::println);
		// names.forEachOrdered(System.out::println);
		
		// names.sorted().forEach(System.out::println);
		// names.sorted().forEachOrdered(System.out::println);
		
		names.parallel().sorted().forEach(System.out::println);
		// names.parallel().sorted().forEachOrdered(System.out::println);
	}

}
