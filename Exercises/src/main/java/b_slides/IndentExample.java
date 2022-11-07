package b_slides;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class IndentExample 
{
	public static void main(String[] args) 
	{
		var str1 = "first_line\nsecond_line\nlast_line"; 
		System.out.println(str1.length()); 
		
		var str2 = str1.indent(0); 
		System.out.println(str2.length()); 
	}
}
