package solutions.part1;

import java.util.function.Predicate;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01d_var 
{
	public static void main(String[] args) 
	{
		final Predicate<Long> isEven = n -> n % 2 == 0;
		var isOdd = isEven.negate();
		
		//var isEmpty = String::isEmpty;
		var isEmptyV1 = ( Predicate<String>)String::isEmpty;
		Predicate<String> isEmptyV2 = String::isEmpty;
	}
}
