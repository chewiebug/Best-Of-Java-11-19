package a_questions;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// https://www.zeitumstellung.de/geschichte-der-sommerzeit.html
/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Hochsommerzeit {

	public static void main(String[] args) {

		for (LocalDateTime ldt : new LocalDateTime[] {
			LocalDateTime.of(1947, Month.APRIL, 6, 0, 0),
			LocalDateTime.of(1947, Month.APRIL, 7, 0, 0),
			LocalDateTime.of(1947, Month.MAY, 11, 0, 0),
			LocalDateTime.of(1947, Month.MAY, 12, 0, 0),
			LocalDateTime.of(1947, Month.JUNE, 29, 0, 0),
			LocalDateTime.of(1947, Month.JUNE, 30, 0, 0),
			LocalDateTime.of(1947, Month.OCTOBER, 5, 0, 0),
			LocalDateTime.of(1947, Month.OCTOBER, 6, 0, 0),
		}) {
//			System.out.println(ldt);
	
			ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Berlin"));
			System.out.println(zdt.toInstant());
		}
	}

}