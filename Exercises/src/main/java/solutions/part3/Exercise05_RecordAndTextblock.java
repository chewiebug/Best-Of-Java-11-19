package solutions.part3;

import java.time.LocalDate;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise05_RecordAndTextblock {

	record Person(String firstName, String lastName, LocalDate birthday) 
	{
		public Person 
		{
			if (firstName.length() < 3 || lastName.length() < 3) 
			{
				String errorMsg = String.format("first and last name must be at leat 3 chars long");
				throw new IllegalArgumentException(errorMsg);
			}

			if (birthday.isAfter(LocalDate.now())) 
			{
				String errorMsg = String.format("birthday can not be in the future");
				throw new IllegalArgumentException(errorMsg);
			}
		}

		String toXml() 
		{
			return """
					<Person>
						<firstName>%s</firstName>
						<lastName>%s</lastName>
						<birthday>%s</birthday>
					</Person>					
					""".formatted(firstName, lastName, birthday);
					/* Achtung nicht: """.format(firstName, lastName, birthday);*/
		}

		String toJSON() 
		{
			return """
					(
					 	"firstName" : "%s",
						"lastName" : "%s", 
						"birthday" : "%s"
					)
					""".formatted(firstName, lastName, birthday);
		}
	}

	public static void main(String[] args) {
		Person mike = new Person("Michael", "Inden", LocalDate.of(1971, 2, 7));

		System.out.println(mike);
		System.out.println(mike.toXml());
		System.out.println(mike.toJSON());
		
		try {
			Person toShort = new Person("Mi", "In", LocalDate.of(1971, 2, 7));

			System.out.println(toShort);
			System.out.println(toShort.toXml());
			System.out.println(toShort.toJSON());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Person captainFuture = new Person("Captain", "Future", LocalDate.of(2071, 2, 7));

			System.out.println(captainFuture);
			System.out.println(captainFuture.toXml());
			System.out.println(captainFuture.toJSON());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
