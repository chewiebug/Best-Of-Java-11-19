package b_slides;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import a_questions.SpecialPerson;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class UnicodeProperties 
{
	public static void main(final String[] args) throws Exception 
	{
		try (final InputStream propertyFile = new FileInputStream("src/main/resources/b_slides/unicode.properties")) 
		{
			final ResourceBundle properties = new PropertyResourceBundle(propertyFile);

			// JDK 9: Enumration => Iterator
			properties.getKeys().asIterator().forEachRemaining(key -> {
				System.out.println(key + " = " + properties.getString(key));
			});
		}
		
		new SpecialPerson("Peter", LocalDate.now());
	}
}
