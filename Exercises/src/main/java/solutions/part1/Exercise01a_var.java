package solutions.part1;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01a_var 
{
	public static void main(String[] args) 
	{
		funWithVar();
	}

	static void funWithVar()
	{
		var name = "Mike";
		var age = 47;
		
		System.out.println(String.format("name: %s, age: %s", name.getClass().getSimpleName(), 
				((Object)age).getClass().getSimpleName()));
		
	}
}