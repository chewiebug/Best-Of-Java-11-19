package exercises.part2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
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
		System.out.println("Aufgabe 1a");
		Stream<LocalDate> allSundays = allBetween(DayOfWeek.SUNDAY, start, end);
		System.out.println("#Sundays in 2017: " + allSundays.count());

		// Aufgabe 1 b
		System.out.println("Aufgabe 1b");
		List<LocalDate> allSundaysInRange = allBetween(DayOfWeek.SUNDAY, start, end)
				.skip(5)
				.limit(7)
				.collect(Collectors.toList());
		
		// [2017-02-05, 2017-02-12, 2017-02-19, 2017-02-26, 2017-03-05, 2017-03-12, 2017-03-19]
		System.out.println(allSundaysInRange);
		
		var firstDayOfNextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("firstDayOfNextMonth: " + firstDayOfNextMonth);


		// Bonus
		System.out.println("Bonus");
		final LocalDate start2018 = LocalDate.of(2012, 1, 1);
		final LocalDate end2018 = LocalDate.of(2013, 1, 1);

		// TODO
	}

	// Tipp: 
	private static Stream<LocalDate> allBetween(DayOfWeek dayOfWeek, LocalDate start, LocalDate end) 
	{
		return start.datesUntil(end)
				.filter(localDate -> localDate.getDayOfWeek().equals(dayOfWeek)); // TODO
	}
}
