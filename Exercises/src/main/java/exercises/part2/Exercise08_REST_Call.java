package exercises.part2;

import java.net.http.HttpClient;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise08_REST_Call 
{
	public static void main(String[] args) throws Exception 
	{
		// HTTP/2-API
		HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();

		// Stream mit monatlicher Schrittweite

		// DATESUNTIL: TODO
		LocalDate localDate = LocalDate.of(2020, 5, 26);

		// TEMPORALADJUSTERS
		LocalDate endOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());

		// var seit Java 10 und Aufruf mit HTTP/2-API
		var optResponseBody = performGet(httpClient, endOfMonth);

		// OPTIONAL-Handling: TODO
	}

	private static Optional<String> performGet(HttpClient httpClient, LocalDate desiredDate) 
	{
		try 
		{
			// TODO
			return Optional.empty();
		}
		catch (Exception ex) 
		{
			// LOG
		}
		return Optional.empty();
	}
}
