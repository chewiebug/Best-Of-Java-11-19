package exercises.part2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise06_StringsAndFiles 
{
	public static void main(String[] args) throws IOException 
	{
		final Path filePath = Paths.get("test.txt");

		System.out.println(filePath.toAbsolutePath());

		// TODO

		Files.writeString(filePath, "One\n");
		Files.writeString(filePath, "Two\n", StandardOpenOption.APPEND);
		Files.writeString(filePath, "Three\n", StandardOpenOption.APPEND);

		final List<String> allLines = Files.readString(filePath, StandardCharsets.UTF_8)
				.lines()
				.toList(); // TODO;
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
