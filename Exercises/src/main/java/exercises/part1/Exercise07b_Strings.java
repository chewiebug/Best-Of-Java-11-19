package exercises.part1;

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
	static final int WIDTH = 10;
	static final String PADDING_CHARACTER = " ";

	public static void main(String[] args) 
	{
		Stream.of(2,4,7,3,1,9,5)
				.map(number -> (number + "").repeat(number))
				.map(repeatedText -> PADDING_CHARACTER.repeat(WIDTH - repeatedText.length()) + repeatedText)
				.forEach(System.out::println); // TODO
	}
	
	private static String formatRightAligned(final int num, final int desiredLength)
	{
		// TODO
		
		return "";
	}

}
