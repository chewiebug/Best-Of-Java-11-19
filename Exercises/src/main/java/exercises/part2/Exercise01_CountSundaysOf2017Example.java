package exercises.part2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01_CountSundaysOf2017Example 
{
	public static void main(String[] args) 
	{
		final LocalDate start = LocalDate.of(2017, 1, 1);
		final LocalDate end = LocalDate.of(2018, 1, 1);
		
		// Aufgabe 1 a 
		Stream<LocalDate> allSundays = allBetween(DayOfWeek.SUNDAY, start, end);
		System.out.println("#Sundays in 2017: " + allSundays.count());

		// Aufgabe 1 b
		List<LocalDate> allSundaysInRange = /* TODO */ null;
		
		// [2017-02-05, 2017-02-12, 2017-02-19, 2017-02-26, 2017-03-05, 2017-03-12, 2017-03-19]
		System.out.println(allSundaysInRange);
		
		
		// Bonus
		final LocalDate start2018 = LocalDate.of(2012, 1, 1);
		final LocalDate end2018 = LocalDate.of(2013, 1, 1);

		// TODO
	}

	// Tipp: 
	private static Stream<LocalDate> allBetween(DayOfWeek dayOfWeek, LocalDate start, LocalDate end) 
	{
		return Stream.of(); // TODO
	}
}
