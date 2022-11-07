package solutions.part2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
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
public class Exercise07a_Http2Example
{
    public static void main(final String[] args) throws Exception
    {
        final URI uri = new URI("https://www.oracle.com/index.html");

        final HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();
        
        final HttpResponse<String> response = httpClient.send(request, asString);

        printResponseInfo(response);
    }

    private static void printResponseInfo(final HttpResponse<String> response)
    {
        final int responseCode = response.statusCode();
        final String responseBody = response.body();
        final HttpHeaders headers = response.headers();
        
        System.out.println("Status:  " + responseCode);
        System.out.println("Body:    " + responseBody);
        System.out.println("Headers: " + headers.map());
    }
}