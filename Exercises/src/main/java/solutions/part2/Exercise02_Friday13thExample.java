package solutions.part2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		final LocalDate start = LocalDate.of(1900, 1, 1);
		final LocalDate end = LocalDate.of(2021, 1, 1);
		
		// Aufgabe 2 a
		Predicate<? super LocalDate> isFriday = day -> day.getDayOfWeek() == DayOfWeek.FRIDAY;
		Predicate<? super LocalDate> is13th = day -> day.getDayOfMonth() == 13;
		final List<LocalDate> allFriday13th = start.datesUntil(end).
		      filter(isFriday).
		      filter(is13th).
		      collect(Collectors.toList());

		System.out.println(allFriday13th);

		final Predicate<LocalDate> isFriday13th = day -> day.getDayOfWeek() == DayOfWeek.FRIDAY && 
				                                  day.getDayOfMonth() == 13;
		final Map<Integer, List<LocalDate>> allFriday13th_2 = start.datesUntil(end).
		      filter(isFriday13th).		    
		      //collect(Collectors.groupingBy(day -> day.getYear()));
		      collect(Collectors.groupingBy(LocalDate::getYear));
		final SortedMap<Integer, List<LocalDate>> sortedFriday13ths = new TreeMap<>(allFriday13th_2);
		sortedFriday13ths.forEach((key, value) -> System.out.println("Year " + key + ": " + value));
		
		// 2 b
		final LocalDate start2010 = LocalDate.of(2010, 1, 1);
		final LocalDate end2017 = LocalDate.of(2018, 1, 1);
		
		final long allFeb29thsCount = start2010.datesUntil(end2017).
		      filter(day -> day.getMonth() == Month.FEBRUARY).
		      filter(day -> day.getDayOfMonth() == 29).
		      count();
		
		System.out.println("February 29ths 2010-2017: " + allFeb29thsCount);
		
		// Spezialfall: Geburtstag an einem Schaltjahr
		// 2 c		
		final Predicate<LocalDate> myBirthdayOnSundayNormal = 
				day -> day.getDayOfWeek() == DayOfWeek.SUNDAY &&
				day.getMonth() == Month.FEBRUARY &&
                day.getDayOfMonth() == 7;
				
		final Predicate<LocalDate> isBirthdayForFeb29 = day-> {
			Year year = Year.of(day.getYear());
			if (year.isLeap())
			{
			    return day.getMonth() == Month.FEBRUARY &&
		                day.getDayOfMonth() == 29;	
			}
			else
			{
			    return day.getMonth() == Month.FEBRUARY &&
		                day.getDayOfMonth() == 28;	
			}			
		};
		final Predicate<LocalDate> onSonday = day -> day.getDayOfWeek() == DayOfWeek.SUNDAY;
		final Predicate<LocalDate> myBirthdayOnSundayFor29 = 
				onSonday.and(isBirthdayForFeb29);
						
		final List<LocalDate> allBirthdaysOnSundays = start2010.datesUntil(end2017).
			  filter(myBirthdayOnSundayFor29).
		      collect(Collectors.toList());
		
		System.out.println("My Birthday on Sunday 2010-2017: " + allBirthdaysOnSundays);	
	}
}
