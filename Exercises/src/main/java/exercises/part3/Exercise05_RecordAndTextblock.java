package exercises.part3;

import java.time.LocalDate;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise05_RecordAndTextblock {

	record Person(String firstName, String lastName, LocalDate birthday) {
		String toXml() {
			return """
                   <person>
                       <firstName>%s</firstName>
                       <lastName>%s</lastName>
                       <birthday>%s</birthday>
                   </person>
                   """.formatted(firstName, lastName, birthday);
		}

		String toJSON() {
			return """
                    {
                        "firstName": "%s",
                        "lastName": "%s",
                        "birthday": "%s"
                    }
                    """.formatted(firstName, lastName, birthday);
		}
	}

	public static void main(String[] args)
	{
		Person mike = new Person("Michael", "Inden", LocalDate.of(1971, 2, 7)); 
		
		System.out.println(mike);
		System.out.println(mike.toXml());
		System.out.println(mike.toJSON());
	}

}
