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
public class Exercise07c_Strings
{
	public static void main(String[] args) 
	{
		Function<Integer, String> mapper = num -> formatRightAligned(num, 10, '0');
		
		Stream.of(2,4,7,3,1,9,5).sorted().map(mapper).
		                         forEach(System.out::println);
		
		Function<Integer, String> mapper2 = num -> formatRightAligned(num, 10, '_');
		
		Stream.of(2,4,7,3,1,9,5).sorted().map(mapper2).
		                         forEach(System.out::println);
	}
	
	private static String formatRightAligned(final int num, final int desiredLength, final char fillChar)
	{
		var multiNumbers = ("" + num).repeat(num);
		
		var padding = calcPadding(num, desiredLength, fillChar);
		
		return "'" + padding + multiNumbers + "'";
	}

	private static String calcPadding(final int num, int desiredLength, final char fillChar)
	{
		var padding = "";
		if (num < desiredLength)
		{
			padding = String.valueOf(fillChar).repeat(desiredLength - num);
		}
		return padding;
	}
}
