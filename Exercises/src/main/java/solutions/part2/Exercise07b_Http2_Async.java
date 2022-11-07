package solutions.part2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07b_Http2_Async
{
    public static void main(final String[] args) throws Exception
    {
        final URI uri = new URI("https://www.oracle.com/index.html");

        final HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        final BodyHandler<String> asString = HttpResponse.BodyHandlers.ofString();

        final HttpClient httpClient = HttpClient.newHttpClient();
        final CompletableFuture<HttpResponse<String>> asyncResponse = 
                                                      httpClient.sendAsync(request, 
                                                                           asString);
        asyncResponse.thenAccept(response -> printResponseInfo(response)).
                      orTimeout(2, TimeUnit.SECONDS).
                      exceptionally(th -> {
                          asyncResponse.cancel(true);
                          System.err.println("timeout");
                          return null;
                      });

//        waitForCompletion();
//        if (asyncResponse.isDone())
//        {
//            final HttpResponse<String> response = asyncResponse.get();
//            printResponseInfo(response);
//        }
//        else
//        {
//            asyncResponse.cancel(true);
//            System.err.println("timeout");
//        }
        
        Thread.sleep(5_000);
    }

    private static void waitForCompletion() throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("Step " + i);
            Thread.sleep(200);
        }
    }

    private static void printResponseInfo(final HttpResponse<String> response)
    {
        final int responseCode = response.statusCode();
        final String responseBody = response.body();

        System.out.println("Status: " + responseCode);
        System.out.println("Body:   " + responseBody);
    }
}
