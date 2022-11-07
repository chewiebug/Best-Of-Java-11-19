package solutions.part2;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise09_HelloWorld 
{
	public static void main(String... args) 
	{
		System.out.println("Hello Execute After Compile");
		
		var procesInfo = ProcessHandle.current().info();
		System.out.println(procesInfo);
    }
}