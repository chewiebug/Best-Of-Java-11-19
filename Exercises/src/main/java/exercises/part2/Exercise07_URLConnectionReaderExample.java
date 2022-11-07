package exercises.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07_URLConnectionReaderExample
{
    public static void main(final String[] args) throws IOException, URISyntaxException, InterruptedException {
        // readOraclePageJdk8();

        readOraclePageJdk9();
    }

    private static void readOraclePageJdk9() throws URISyntaxException,
            IOException,
            InterruptedException
    {
        final URI uri = new URI("https://www.oracle.com/index.html");
        final HttpRequest httpRequest = HttpRequest.newBuilder(uri).GET().build();
        final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();

        final HttpClient httpClient = HttpClient
                .newBuilder()
                .followRedirects(Redirect.ALWAYS)
                .build();
        final HttpResponse<String> response = httpClient.send(httpRequest, asString);

        printResponseInfo(response);
    }

    private static void printResponseInfo(HttpResponse<String> response) {
        System.out.println("response code: " + response.statusCode());
        System.out.println("response body: " + response.body());
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
