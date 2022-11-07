package a_questions;

import java.util.Arrays;
import java.util.List;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class DeepImmCopy 
{
	public static void main(String[] args) {

		List<String> names = Arrays.asList("Tim", "Tom", "Mike");
		List<String> names2 = Arrays.asList("Tim2", "Tom2", "Mike2");
		List<String> names3 = Arrays.asList("Tim3", "Tom3", "Mike3");

		List<List<String>> all = Arrays.asList(names, names2, names3);
		System.out.println(all.getClass());
		System.out.println(all.get(0).getClass());

		List<List<String>> copy = List.copyOf(all);
		System.out.println(copy.getClass());
		System.out.println(copy.get(0).getClass());
	}
}
