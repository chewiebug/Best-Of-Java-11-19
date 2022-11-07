package java18.newswitch;

import java.time.DayOfWeek;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class SwitchExample
{
    public static void main(final String[] args)
    {
        int numLetters = 0;

        final DayOfWeek day = DayOfWeek.WEDNESDAY;
        switch (day)
        {
            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
            case TUESDAY -> numLetters = 7;
            case THURSDAY, SATURDAY -> numLetters = 8;
            case WEDNESDAY -> numLetters = 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(numLetters);
    }
}
