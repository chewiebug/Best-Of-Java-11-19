package a_questions;

/*
 * There are three different whitespaces character in String " Java 11 features ":

    character tabulation: U+0009 (9)
    space: U+0020 (32)
    em space: U+2003 (8195)
 */
/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class StringStrip {

	public static void main(String[] args) {

		String s = "	 JAVA 11 FEATURES  ";

		System.out.printf("String: \"%s\"%n", s);

		String striped = s.strip();

		System.out.printf("strip(): \"%s\"%n", striped);

		String stripLeft = s.stripLeading();

		System.out.printf("stripLeading(): \"%s\"%n", stripLeft);

		String stripRight = s.stripTrailing();

		System.out.printf("stripTrailing(): \"%s\"%n", stripRight);

		String trimmed = s.trim();

		System.out.printf("trim(): \"%s\"%n", trimmed);

		System.out.println("striped.equals(trimmed): " + striped.equals(trimmed));

		System.out.println("Reason: ");
		for (char c : s.toCharArray()) {
			if (c >= ' ' && c <= 'Z')
				System.out.print(c);
			else
				System.out.printf("'%s'", String.valueOf((int) c));
		}
	}

}