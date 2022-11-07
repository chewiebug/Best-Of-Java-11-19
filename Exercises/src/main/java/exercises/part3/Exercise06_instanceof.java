package exercises.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise06_instanceof 
{
	public static void main(String[] args) 
	{	
		Object obj ="BITTE ein BIT";
		
		if (obj instanceof String) 
		{
			final String str = (String)obj; 
			if (str.contains("BITTE"))
			{
		         System.out.println("It contains the magic word!");
		    }
		}

		if (obj instanceof String text && text.contains("BITTE")) {
			System.out.println("'" + text + "' contains the magic word!");
		}
	}
}
