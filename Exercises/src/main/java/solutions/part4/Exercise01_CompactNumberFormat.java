package solutions.part4;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01_CompactNumberFormat 
{
	public static void main(final String args[]) 
	{
		List<Integer> allValues = List.of(1_000, 1_000_000, 1_000_000_000);
		List<String> germanParseInputs = List.of("13 KILO", "1 Mio.", "1 Mrd.");
		List<String> italianParseInputs = List.of("mille", "1 milione");
		
		var shortFormat = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);
		formatNumbers("SHORT", shortFormat, allValues);
		parseNumbers("SHORT", shortFormat, germanParseInputs);

		var longFormat = NumberFormat.getCompactNumberInstance(Locale.ITALY, NumberFormat.Style.LONG);
		formatNumbers("LONG", longFormat, allValues);
		parseNumbers("LONG", longFormat, italianParseInputs);
		
		formattingExamples();
	}

	private static void formatNumbers(final String style,
			                          final NumberFormat format,
			                          final List<Integer> values) 
	{
		System.out.println("\nNumberFormat " + style);
				
		values.forEach(value -> {
			System.out.println("Result: (" + value + ") => " + format.format(value));
		});
	}
	
	private static void parseNumbers(final String style,
                                     final NumberFormat format,
                                     final List<String> textValues) 
	{
		System.out.println("\nNumberFormat " + style);

		textValues.forEach(textValue -> {
			try {
				System.out.println("Result: (" + textValue + ") => " + format.parse(textValue));
			} catch (ParseException e) {
				System.out.println("Result: (" + textValue + ") => not parsable");
				e.printStackTrace();
			}
		});
	}
	
	// 
	private static void formattingExamples()
	{
		final var germanFormat = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);
		final var italianFormat = NumberFormat.getCompactNumberInstance(Locale.ITALIAN, NumberFormat.Style.LONG);
		final var englishFormat = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);

		System.out.println("1000->"+germanFormat.format(1000));
		System.out.println("1.000.000 ->"+germanFormat.format(1_000_000));
		System.out.println("1.000.000.000 ->"+germanFormat.format(1_000_000_000));
		
		System.out.println("1000->"+italianFormat.format(1000));
		System.out.println("1.000.000 ->"+italianFormat.format(1_000_000));
		System.out.println("1.000.000.000 ->"+italianFormat.format(1_000_000_000));
		
		System.out.println("1000->"+englishFormat.format(1000));
		System.out.println("1.000.000 ->"+englishFormat.format(1_000_000));
		System.out.println("1.000.000.000 ->"+englishFormat.format(1_000_000_000));
	}
}
