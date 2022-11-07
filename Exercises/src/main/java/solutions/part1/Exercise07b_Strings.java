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
public class Exercise07b_Strings 
{
	public static void main(String[] args) 
	{
		Function<Integer, String> mapper = num -> formatRightAligned(num, 10);
		
		Stream.of(2,4,7,3,1,9,5).map(mapper).
		                         forEach(System.out::println);
		
		Stream.of(2,4,7,3,1,9,5).sorted().map(mapper).
                                          forEach(System.out::println);
		
		// Variante mit Java 12+ 
		System.out.println("abc".indent(7).stripTrailing());
		System.out.println("    abc".indent(-4).strip());	
	}
	
	private static String formatRightAligned(final int num, final int desiredLength)
	{
		var multiNumbers = ("" + num).repeat(num);
		
		var padding = calcPadding(num, desiredLength);
		
		return "'" + padding + multiNumbers + "'";
	}

	private static String calcPadding(final int num, int desiredLength) {
		var padding = "";
		if (num < desiredLength)
		{
			padding = " ".repeat(desiredLength - num);
		}
		
		return padding;
	}
}