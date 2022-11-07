package solutions.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise05_Reader 
{
	public static void main(String[] args) throws IOException 
	{
		var textFile = new File("hello.txt");
		var sr = new StringReader("Hello\nWorld");
				
		try (var bfw = new BufferedWriter(new FileWriter(textFile)))
		{
			sr.transferTo(bfw);
		}

		var sw = new StringWriter();
		try (var bfr = new BufferedReader(new FileReader(textFile)))			
		{
			bfr.transferTo(sw);
		}
		System.out.println(sw.toString());
	}
}