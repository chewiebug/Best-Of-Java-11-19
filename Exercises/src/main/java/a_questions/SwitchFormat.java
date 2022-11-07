package a_questions;

import java.time.DayOfWeek;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class SwitchFormat
{
    public static void main(String[] args)
    {

        DayOfWeek day = DayOfWeek.FRIDAY;
        int numLetters = switch (day)
        {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
        };
    }
}
