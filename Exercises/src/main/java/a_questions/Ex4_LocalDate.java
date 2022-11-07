package a_questions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Ex4_LocalDate {

	public static void main(String[] args) {

		LocalDate start = LocalDate.of(2010, 1, 1);
		LocalDate end = LocalDate.of(2022, 1, 1);

		long sunddaycount = start.datesUntil(end).filter(date -> date.getDayOfWeek() == DayOfWeek.SUNDAY).count();
		System.out.println(sunddaycount);

		Predicate<LocalDate> isFriday = date -> date.getDayOfWeek() == DayOfWeek.FRIDAY;
		Predicate<LocalDate> is13th = date -> date.getDayOfMonth() == 13;
		Predicate<LocalDate> friday13ths = isFriday.and(is13th);

		start.datesUntil(end).filter(friday13ths).forEach(System.out::println);
	}
}
