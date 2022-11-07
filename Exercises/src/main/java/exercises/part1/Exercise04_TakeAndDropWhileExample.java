package exercises.part1;

import java.util.List;
import java.util.function.Predicate;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise04_TakeAndDropWhileExample 
{
    public static void main(final String[] args) 
    {
		final Predicate<String> isBodyStart = /*TODO */ null;
		final Predicate<String> isBodyEnd = /*TODO */ null;
		
		final List<String> tokens = List.of("<html>", 
			  "<head>", "<title>This is TITLE</title>", "</head>",
		      "<body>",
		        "<h1>THIS IS THE H1 HEADER</h1>",
		        "<p>Paragraph content</p>",
		      "</body>",
		    "</html>");
		
		extractor(tokens, isBodyStart, isBodyEnd).forEach(System.out::println);
		
		// REUSE to EXTRACT HEAD infos
		extractor(tokens, str -> str.equalsIgnoreCase("<HEAD>"), 
				          str -> str.equalsIgnoreCase("</HEAD>")).forEach(System.out::println);
    }

	private static List<String> extractor(List<String> tokens, Predicate<String> isStart, Predicate<String> isEnd) 
	{		
		return /*TODO */ null;
	}
}

