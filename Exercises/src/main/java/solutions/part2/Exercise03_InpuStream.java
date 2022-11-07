package solutions.part2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise03_InpuStream 
{
	public static void main(final String[] arguments) throws IOException
	{
		final String fileName = arguments[0];

		copyFileJdk9(fileName);
	}

	private static void copyFileJdk9(final String fileName) throws IOException, FileNotFoundException {
		try (final InputStream is = new FileInputStream(fileName);
			 final OutputStream os = new FileOutputStream(fileName + ".copy"))
		{
			is.transferTo(os);
		}
	}

	private static void copyFileUsingStream(File source, File dest) throws IOException 
	{
	    try (final InputStream is = new FileInputStream(source);
	    	 final OutputStream os = new FileOutputStream(dest))
	    {
	    	final byte[] buffer = new byte[2048];
			int length;
			while ((length = is.read(buffer)) > 0) 
			{
			    os.write(buffer, 0, length);
			}
			os.flush();
	    } 
	}
}
