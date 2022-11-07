package a_questions;

import java.time.Month;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class FallThroughExample {

	public static void main(String[] args) {

		printMonth(Month.JULY);
		printMonth(Month.APRIL);
	}

	private static void printMonth(Month month) {
		String monthString = "";
		switch (month) {
		case JANUARY:
			monthString = "January";
			break;
		default:
			monthString = "N/A"; // hier auch noch Fall Through
		case FEBRUARY:
			monthString = "February";
			break;
		case MARCH:
			monthString = "March";
			break;
		case JULY:
			monthString = "July";
			break;
		}

		System.out.println("OLD: " + month + " = " + monthString); // February
	}
}