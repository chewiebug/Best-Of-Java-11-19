package a_questions;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class EnumExample {

	public static void main(String[] args) {

		enum Color {
			RED, GREEN, BLUE, ORANGE, YELLOW
		}
		

		Color favoriteColor = Color.BLUE;
		switch (favoriteColor) {
    		case BLUE -> System.out.println("You like blue");
    		case GREEN -> System.out.println("You prefer green");
    		case ORANGE -> throw new UnsupportedOperationException("Unimplemented case: " + favoriteColor);
    		case RED -> throw new UnsupportedOperationException("Unimplemented case: " + favoriteColor);
		case YELLOW -> throw new UnsupportedOperationException("Unimplemented case: " + favoriteColor);
		default -> throw new IllegalArgumentException("Unexpected value: " + favoriteColor);
		}
		
		
		int value = 42;
		switch (value)
		{
		    case 0 -> System.out.println("ZERO");
	        case 42 -> System.out.println("PERFECT ANSWER");
	        default -> throw new IllegalArgumentException("Unexpected value: " + favoriteColor);
		}
	}
}
