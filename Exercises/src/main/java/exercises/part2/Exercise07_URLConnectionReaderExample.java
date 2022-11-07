package exercises.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07_URLConnectionReaderExample
{
    public static void main(final String[] args) throws IOException
    {
        readOraclePageJdk8();
    }

	private static void readOraclePageJdk8() throws MalformedURLException, IOException 
	{
		final URL oracleUrl = new URL("https://www.oracle.com/index.html");
        final URLConnection connection = oracleUrl.openConnection();

        final String content = readContent(connection.getInputStream());
        System.out.println(content);
	}

    public static String readContent(final InputStream is) throws IOException
    {
        try (final InputStreamReader isr = new InputStreamReader(is); final BufferedReader br = new BufferedReader(isr))
        {
            final StringBuilder content = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null)
            {
                content.append(line + "\n");
            }

            return content.toString();
        }
    }
}
