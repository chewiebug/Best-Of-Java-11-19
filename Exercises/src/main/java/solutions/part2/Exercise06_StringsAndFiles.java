package solutions.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise06_StringsAndFiles 
{
	public static void main(String[] args) throws IOException 
	{
		final Path filePath = Paths.get("test.txt");
		
		Files.writeString(filePath, "1: One\n");
		Files.writeString(filePath, "2: Two\n", StandardOpenOption.APPEND);
		Files.writeString(filePath, "3: Three", StandardOpenOption.APPEND);
		
		final String content = Files.readString(filePath);
		
		final List<String> allLines = content.lines().collect(Collectors.toList());
		allLines.forEach(System.out::println);
		
		// Multi-Line als neues Feature
		Files.writeString(filePath, """
		1: One
		2: Two
		3: Three
		""");
		
		final List<String> allLines2 = Files.readAllLines(filePath);
		System.out.println(allLines2);
	}
}
