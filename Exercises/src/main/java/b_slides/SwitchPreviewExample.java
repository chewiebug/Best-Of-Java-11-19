package b_slides;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class SwitchPreviewExample {

	/*
	public static void main(String[] args) {
		
		processData("V1");
		processData("V2");
		processData(71);
		
		switchSupportingNull("Python");

		// not working in Eclipse?!
		switchSupportingNull(null);
	}

	static void switchSupportingNull(String str) {
		switch (str) {
		case null -> System.out.println("null is allowed in preview");
		case "Java", "Python" -> System.out.println("cool language");
		default -> System.out.println("everything else");
		}
	}

	static void processData(Object obj) {
		switch (obj) {
		case String str && str.startsWith("V1") -> System.out.println("Processing V1");
		case String str && str.startsWith("V2") -> System.out.println("Processing V2");
		case Integer i && i > 10 && i < 100 -> System.out.println("Processing ints");
		default -> throw new IllegalArgumentException("invalid input");
		}
	}
	*/
}

