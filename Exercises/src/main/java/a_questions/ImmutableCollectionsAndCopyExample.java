package a_questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class ImmutableCollectionsAndCopyExample {
	public static void main(String[] args) 
	{				
		final List<String> names = new ArrayList<>(List.of("Tim", "Tom", "Mike"));
		        // final String[] baseNames = { "A", "B", "C" };
				// Arrays.asList(baseNames); // => Änderunegn am Basisarray möglich und reflektiert
				// Arrays.asList("Tim", "Tom", "Mike"); // => keine Änderungen erlaubt
				//List.of("Tim", "Tom", "Mike"); // => keine Änderungen erlaubt
						
		// 3 Varianten Kopien von unmodifizierbaren Listen zu erzeugen
		final List<String> copy1 = new ArrayList<>(names);
		final List<String> copy2 = List.copyOf(names);
		final List<String> wrapper = Collections.unmodifiableList(names);
		
		// Modifikation in Kopie
		tryModification("copy1", copy1);
		tryModification("copy2", copy2);
		tryModification("wrapper", wrapper);
		
		// Modifikationen im Original
		names.set(0, "FIRST SURPRISE");
		names.add("LAST SURPRISE");
		// baseNames[1] = "AUAUAUAUAU";
		
		System.out.println(copy1);
		System.out.println(copy2);
		System.out.println(wrapper);
	}

	private static void tryModification(final String info, final List<String> list) 
	{
		try
		{
			list.set(1, "XXX");
			System.out.println(info + ": " + list);
		}
		catch (java.lang.UnsupportedOperationException ex)
		{
			System.out.println(info + ": set() not allowed");
		}
	}
}
