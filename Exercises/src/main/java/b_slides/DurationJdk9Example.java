package b_slides;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class DurationJdk9Example 
{
    public static void main(final String[] args)
    {
        final Duration tenDaysSevenHoursThirtyMinutes = Duration.ofDays(10).plusHours(7).plusMinutes(30);
        // Vordefinierte Durations
        final Duration oneDay = Duration.ofDays(1);
        final Duration oneHour = Duration.ofHours(1);
        final Duration _15Mins = Duration.ofMinutes(15);
        
        // JDK 9: divideBy(Duration)
        final long wholeDays = tenDaysSevenHoursThirtyMinutes.dividedBy(oneDay);
        final long wholeHours = tenDaysSevenHoursThirtyMinutes.dividedBy(oneHour);
        final long howMany15Mins = tenDaysSevenHoursThirtyMinutes.dividedBy(_15Mins);
        
        System.out.println("wholeDays:        " + wholeDays);
        System.out.println("wholeHours:       " + wholeHours);
        System.out.println("howMany15Minutes: " + howMany15Mins);
        
        // JDK 9: truncatedTo(TemporalUnit) 
        System.out.println("truncatedTo(DAYS): " + tenDaysSevenHoursThirtyMinutes.truncatedTo(ChronoUnit.DAYS));
        System.out.println("truncatedTo(HOURS):   " + tenDaysSevenHoursThirtyMinutes.truncatedTo(ChronoUnit.HOURS));
        System.out.println("truncatedTo(MINUTES): " + tenDaysSevenHoursThirtyMinutes.truncatedTo(ChronoUnit.MINUTES));
    }
}