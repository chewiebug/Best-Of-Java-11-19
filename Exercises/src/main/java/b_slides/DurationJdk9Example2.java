package b_slides;

import java.time.Duration;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class DurationJdk9Example2 
{
	public static void main(String[] args) 
	{
		final Duration tenDaysSevenHoursThirdMinutes = Duration.ofDays(10).plusHours(7).plusMinutes(30);

		// JDK 9:toXXX() und toXXXPart()
		System.out.println("toDays():        " + tenDaysSevenHoursThirdMinutes.toDays());
		System.out.println("toDaysPart():    " + tenDaysSevenHoursThirdMinutes.toDaysPart());
		System.out.println("toHours():       " + tenDaysSevenHoursThirdMinutes.toHours());
		System.out.println("toHoursPart():   " + tenDaysSevenHoursThirdMinutes.toHoursPart());
		System.out.println("toMinutes():     " + tenDaysSevenHoursThirdMinutes.toMinutes());
		System.out.println("toMinutesPart(): " + tenDaysSevenHoursThirdMinutes.toMinutesPart());
	}
}