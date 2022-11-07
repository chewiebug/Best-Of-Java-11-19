package exercises.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise03_TextBlocks_Placeholders 
{
	public static void main(final String[] args) 
	{
		String multiLineStringWithPlaceHoldersOld = String.format("HELLO \"%s\"!\n" +
				 "  HAVE %s\n" +
				 "  NICE \"%s\"!",
				 new Object[]{"WORLD", "A", "DAY"});
		System.out.println(multiLineStringWithPlaceHoldersOld);

		String multiLineStringWithPlaceHolders = null; // TODO
		System.out.println(multiLineStringWithPlaceHolders);		
	}
}
