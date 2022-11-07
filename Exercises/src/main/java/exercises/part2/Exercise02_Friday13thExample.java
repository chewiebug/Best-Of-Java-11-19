package exercises.part2;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise02_Friday13thExample 
{
	public static void main(String[] args) 
	{
		final LocalDate start = LocalDate.of(2013, 1, 1);
		final LocalDate end = LocalDate.of(2018, 1, 1);
		
		// Aufgabe 7a
		final List<LocalDate> allFriday13th = /* TODO */ null;
		System.out.println(allFriday13th);

		final Predicate<LocalDate> isFriday13th = /* TODO */ null;
		// TODO
		
		// 7b
		final LocalDate start2010 = LocalDate.of(2010, 1, 1);
		final LocalDate end2017 = LocalDate.of(2018, 1, 1);
		
		final long allFeb29thsCount = /* TODO */ 0;
		
		System.out.println("February 29ths 2010-2017: " + allFeb29thsCount);
		
		// 7c		
		final Predicate<LocalDate> myBirthdayOnSunday = /* TODO */ null;
		final List<LocalDate> allBirthdaysOnSundays = /* TODO */ null;
		
		System.out.println("My Birthday on Sunday 2010-2017: " + allBirthdaysOnSundays);	
	}
}
