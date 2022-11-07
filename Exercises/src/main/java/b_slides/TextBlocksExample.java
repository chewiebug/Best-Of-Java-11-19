package b_slides;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class TextBlocksExample {

	public static void main(String[] args) {

		String jsonObj = """
						{
						    "name": "Mike",
					        "birthday": "1971-02-07",
						    "comment": "Text blocks are nice!"
						}
				     """;

		System.out.println(jsonObj);
		
		String text = """
				      This is a string splitted in several smaller \
				      jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj \
				      jjjjjjjjjjjjjjjjjjjjjjjj \
				      jjjjjjjjjjjj strings""";    

		System.out.println(text);
		System.out.println(text.getClass());
	}
}
