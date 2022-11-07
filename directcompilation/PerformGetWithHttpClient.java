import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class PerformGetWithHttpClient 
{
	public static void main(String[] args) throws Exception 
	{
		var client = HttpClient.newBuilder().build();
		URI uri = URI.create("https://reqres.in/api/unknown/2");
		var request = HttpRequest.newBuilder().GET().uri(uri).build();
		
		var response = client.send(request, BodyHandlers.ofString());
		System.out.printf("Response code is: %d %n", response.statusCode());
		System.out.printf("The response body is:%n %s %n", response.body());
	}
}