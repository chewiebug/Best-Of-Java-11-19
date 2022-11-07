package solutions.part1;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07d_Strings 
{
	public static void main(String[] args) 
	{
		Function<? super Integer, ? extends String> mapper1 = num -> ("" + num).repeat(num);
		Stream.of(2,4,7,3,1,9,5,21,12,11,20).sorted().map(mapper1).forEach(System.out::println);
				
		Function<? super Integer, ? extends String> mapper2 = num -> ("" + num).repeat(num);
		Stream.of(2,4,7,3,1,9,5,21,12,11,20).map(mapper2).sorted().forEach(System.out::println);
	}
}
