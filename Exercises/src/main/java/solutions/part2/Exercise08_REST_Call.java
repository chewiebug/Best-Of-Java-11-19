package solutions.part2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

/**
 * Beispielprogramm für den Workshop "Best of Java 9, 10 und 11" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise08_REST_Call 
{
	public static void main(String[] args) throws Exception
	{
	    // HTTP/2-API
		var httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
	
	    // Stream mit monatlicher Schrittweite
	    var startDay = LocalDate.of(2022, Month.JANUARY, 1);
	    var endDay = LocalDate.of(2022, Month.MAY, 1);
	    var stepOneMonth = Period.ofMonths(1);
	  
	    // DATESUNTIL
	    startDay.datesUntil(endDay, stepOneMonth).forEach(localDate -> {
	
	        // TEMPORALADJUSTERS
	        var endOfMonth = 
	                  localDate.with(TemporalAdjusters.lastDayOfMonth());
	
	        // var seit Java 10 und Aufruf mit HTTP/2-API
	        var optResponseBody = performGet(httpClient, endOfMonth);
	
	        // OPTIONAL-Handling
	        optResponseBody.ifPresentOrElse((value) -> System.out.println(endOfMonth + " reported " + value),
	                                       () -> System.out.println("No data for " + endOfMonth));
	    });
	}
	
	private static Optional<String> performGet(HttpClient httpClient, LocalDate desiredDate)
	{
	    String old_key = "51b26ac4e9ec53f00ad3aae88ea45be9";
	    String key = "5e9375c8c908bdc0d6e6a356ea14b860";
	    try
	    {
	        var httpRequest = HttpRequest.newBuilder().GET()
	        		 .uri(URI.create("http://data.fixer.io/" + desiredDate + 
	        		 "?symbols=CHF&access_key="+key)).build();
	
	        var response = httpClient.send(httpRequest, BodyHandlers.ofString());
	        String responseBody = response.body();
	
	        return Optional.of(responseBody);
	    }
	    catch (Exception ex)
	    {
	        // LOG
	    }
	    return Optional.empty();
	}
}

