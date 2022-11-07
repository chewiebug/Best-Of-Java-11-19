package solutions.part2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise04_InpuStreamReadBytesExample 
{
	public static void main(final String[] args) throws IOException 
	{
		final byte[] result1 = readAllBytes();
		System.out.println(new String(result1));
		
		final byte[] result2 = readNBytes(6);
		System.out.println(new String(result2));
		
		getInputStream().transferTo(System.out);
	}

	private static byte[] readAllBytes() throws IOException 
	{
		try (InputStream inputStream = getInputStream()) 
		{
			return inputStream.readAllBytes();			
		}
	}
	
	private static byte[] readNBytes(final int size) throws IOException 
	{
		try (InputStream inputStream = getInputStream()) 
		{			
			final byte[] buffer = new byte[size];
			inputStream.readNBytes(buffer, 0, buffer.length);
			
			return buffer;
		}
	}

	public static InputStream getInputStream() 
	{
		return new ByteArrayInputStream("Java 9 offers some cool new features".getBytes());
	}
}