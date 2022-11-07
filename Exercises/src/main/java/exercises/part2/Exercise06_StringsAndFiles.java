package exercises.part2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
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
		
		// TODO
				
		final List<String> allLines = Collections.emptyList(); // TODO;
		allLines.forEach(System.out::println);
	}
}
