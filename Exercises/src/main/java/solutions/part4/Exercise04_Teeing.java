package solutions.part4;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise04_Teeing 
{
	public static void main(String[] args) throws IOException 
	{
		Comparator<String> byLengthDesc = (str1, str2) -> Integer.compare(str2.length(), str1.length());
		Comparator<String> byLength = (str1, str2) -> Integer.compare(str1.length(), str2.length());
        
		// In einem Durchlauf Minimum und Maximm finden
		Stream<String> values = Stream.of("CCCCCCCCCCCCCCCCCCC", "BB", "AAAAAAAAAAAA", "DDDD");
		List<Optional<String>> optMinMax = values.collect(Collectors.teeing(
				    Collectors.minBy(byLength),
				    Collectors.maxBy(byLength),
				    (optMin, optMax) -> List.of(optMin, optMax)));

		System.out.println(optMinMax); 
	}
}
