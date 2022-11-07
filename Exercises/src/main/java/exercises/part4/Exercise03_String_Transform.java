package exercises.part4;

import java.util.Arrays;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise03_String_Transform
{
	public static void main(String[] args) {
		
		var csvText = "HELLO,WORKSHOP,PARTICIPANTS,!,LET'S,HAVE,FUN";
		
		// Aufgabe 3 a
		var allLowerCaseNoCommas = csvText.toLowerCase().replace(",", " "); 
		System.out.println(allLowerCaseNoCommas);

		
		// Aufgabe 3 b
		var asSingleValues = ""; // TODO
		System.out.println(Arrays.asList(asSingleValues));	
	}
}
