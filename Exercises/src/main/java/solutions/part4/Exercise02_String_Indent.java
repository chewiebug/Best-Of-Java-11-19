package solutions.part4;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise02_String_Indent 
{
	public static void main(String[] args) 
	{
		String originalString = "first_line\nsecond_line\nlast_line";

		// 3a
		System.out.println(originalString);
		System.out.println("-- indented string --");

		String indentedString = originalString.indent(7);
		System.out.println(indentedString);

		System.out.println("-- corrected indented string --");
		String correctIndentedString = indentedString.indent(-3);
		System.out.println(correctIndentedString);

		
		// 3b
		String multipleIndendedString = "class A {\n    public static void main(String[] args) {" + 
                  "\n        System.out.println(\"Hello\"";
		System.out.println(multipleIndendedString);
                  
		System.out.println("-- negatively indended string --");
		String result = multipleIndendedString.indent(-10);
		System.out.println(result);      
	}
}
