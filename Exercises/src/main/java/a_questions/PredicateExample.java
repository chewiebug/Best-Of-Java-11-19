package a_questions;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
import static java.util.function.Predicate.not;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateExample {

	public static void main(String[] args) {
				
		final Predicate<String> isEmpty = String::isEmpty;
		final Predicate<String> notEmptyJdk10 = isEmpty.negate();

		Stream.of("Tim", "", "Tom", "", "Mick", "", "", "ENDE").
		       filter(not(String::isEmpty)).
		       forEach(System.out::println);
		
	}
}
