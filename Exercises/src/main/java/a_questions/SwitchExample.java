package a_questions;

import java.time.DayOfWeek;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class SwitchExample {

	public static void main(String[] args) {

		DayOfWeek day = DayOfWeek.FRIDAY;
		int numletters = switch (day) {

		case MONDAY, FRIDAY, SUNDAY -> 6;
		case TUESDAY -> 7;
		case THURSDAY, SATURDAY -> 8;
		case WEDNESDAY -> {
		    System.out.println("MITTWOCH");
		    yield 9;
		}
		};

		System.out.println(numletters);
		System.out.println((numletters = 6));

		// wenn int / long => nur default als Vervollständigung
		int value = 3;
		int result = switch (value) {
		case 1 -> 1;
		case 2 -> 7;
		case 3 -> 8;
		default -> throw new IllegalArgumentException("Unexpected value: " + value);
		};

		System.out.println("Specail case return and assignment");
		int numletters2 = -1;

		int result2 = switch (day) {

		case MONDAY, FRIDAY, SUNDAY -> numletters2 = 6;
		case TUESDAY -> numletters2 = 7;
		case THURSDAY, SATURDAY -> numletters2 = 8;
		case WEDNESDAY -> numletters2 = 9;
		};

		System.out.println(numletters2);
		System.out.println(result2);
	}
}
