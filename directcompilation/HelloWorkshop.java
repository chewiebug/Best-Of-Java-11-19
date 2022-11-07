package does.not.count;

import java.time.*;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class HelloWorkshop
{
	public static void main(String... args)
	{
		System.out.println("Hello Workshop Participants");
		LocalDate today = LocalDate.now();
		System.out.println("today is the " + today);	
	}
}