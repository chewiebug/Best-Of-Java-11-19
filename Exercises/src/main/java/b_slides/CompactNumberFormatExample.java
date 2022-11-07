package b_slides;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.text.ParseException;
import java.util.Locale;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class CompactNumberFormatExample 
{
	public static void main(String[] args) throws ParseException
	{
	    System.out.println("US/SHORT parsing:");
	
	    var shortFormat = NumberFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
	    System.out.println(shortFormat.parse("1 K")); // ACHTUNG
	    System.out.println(shortFormat.parse("1K"));
	    System.out.println(shortFormat.parse("1M"));
	    System.out.println(shortFormat.parse("1B"));

	    System.out.println("\nUS/LONG parsing:");
	
	    var longFormat = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
	    System.out.println(longFormat.parse("1 thousand"));
	    System.out.println(longFormat.parse("1 million"));
	    System.out.println(longFormat.parse("1 billion"));
	}	
}

