package solutions.part1;

import java.util.Map;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01b_var 
{
	public static void main(String[] args) 
	{
		funWithVar();
	}

	static void funWithVar()
	{
		Map<String, Integer> personsAndAges = Map.of("Tim", 47, "Tom", 7, "Mike", 47);
		var personsAndAges2 = Map.of("Tim", 47, "Tom", 7, "Mike", 47);
	}

}
