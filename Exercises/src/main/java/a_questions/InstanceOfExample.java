package a_questions;


/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
// FOLIEN!!!
public class InstanceOfExample {

	public static void main(String[] args) {
		
	    Object obj2 = "BACSGsJAHG";
	    
        if (obj2 instanceof String) 
        {
            String str2 = (String)obj2;
            if (str2.length() > 5 && str2.startsWith("BA"))
            {
                System.out.println("Länge: " + str2.length());                
            }
        }
        
	    if (obj2 instanceof String str2 && str2.length() > 5 && str2.startsWith("BA"))
	    {
	        //str2 ="THOMAS_jashjadhkjadhj";
	        System.out.println("Länge: " + str2.length());
	    }
	}
}
