package solutions.part2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
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
		Stream<LocalDate> allSundays = start.datesUntil(end).
				                             filter(day -> day.getDayOfWeek() == DayOfWeek.SUNDAY).
				                             peek(System.out::println);
		System.out.println("#Sundays in 2017: " + allSundays.count());

		List<LocalDate> allSundays2 = start.datesUntil(end).
                filter(day -> day.getDayOfWeek() == DayOfWeek.SUNDAY).
                collect(Collectors.toList());
		System.out.println("#Sundays in 2017: " + allSundays2 + " / count: " + allSundays2.size());

		
		Stream<LocalDate> allFridays = start.datesUntil(end).
                filter(isOnWeekDay(DayOfWeek.FRIDAY) );
		System.out.println("#Fridays in 2017: " + allFridays.count());


		Predicate<Integer> isInRange1 = isInRange(10, 50);
		Predicate<Integer> isInRange2 = isInRange(100, 200);
		

		// Aufgabe 1 b
		List<LocalDate> allSundaysInRange = allBetween(DayOfWeek.SUNDAY, start, end).
			      skip(5).
			      limit(7).
			      collect(Collectors.toList());
		
		/*
		Predicate<? super LocalDate> isSunday = day1 -> day1.getDayOfWeek() == DayOfWeek.SUNDAY;		
		List<LocalDate> allSundaysInRange = start.datesUntil(end).
				                                  filter(isOnWeekDay(DayOfWeek.SUNDAY)).
				                                  skip(5).
			                                      limit(7).
			                                      collect(Collectors.toList());
	   */
		
		// [2017-02-05, 2017-02-12, 2017-02-19, 2017-02-26, 2017-03-05, 2017-03-12, 2017-03-19]
		System.out.println(allSundaysInRange);
		
		
		// Bonus
		final LocalDate start2018 = LocalDate.of(2012, 1, 1);
		final LocalDate end2018 = LocalDate.of(2013, 1, 1);

		final Map<DayOfWeek, Long> dayToCountMapping= new TreeMap<>();
		for (final DayOfWeek day : DayOfWeek.values())
		{
			final long numberOfDaysOfType = allBetween(day, start2018, end2018).count();
			dayToCountMapping.put(day, numberOfDaysOfType);
		}
		dayToCountMapping.forEach((key, value) -> System.out.println("Day: "  + key + " / count; " + value));
	}

	private static Predicate<Integer> isInRange(int lower, int upper) {
		return n -> n >= lower && n<= upper;
	}

	// Tipp: 
	private static Stream<LocalDate> allBetween(DayOfWeek dayOfWeek, LocalDate start, LocalDate end) 
	{
		return start.datesUntil(end).filter(day -> day.getDayOfWeek() == dayOfWeek);
	}
	
	static Predicate<? super LocalDate> isSundayAsMethod()
	{
		return day -> day.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

	static Predicate<? super LocalDate> isOnWeekDay(DayOfWeek desiredWeekday)
	{
		return day -> day.getDayOfWeek() == desiredWeekday;
    }	
}
