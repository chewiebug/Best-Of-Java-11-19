package exercises.part2;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise05_Reader 
{
	public static void main(String[] args) throws IOException 
	{
		var textFile = new File("hello.txt");
		var sr = new StringReader("Hello\nWorld");
				
		try (Writer bfw = null /*TODO*/)
		{
			// TODO
		}

		var sw = new StringWriter();
		try (Reader bfr = null /*TODO*/)			
		{
			// TODO
		}
		System.out.println(sw.toString());
	}
}