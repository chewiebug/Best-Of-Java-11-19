package a_questions;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public record MyPoint(int x, int y) 
{ 
	public static void main(String[] args) {
			    
	    MyPoint point = new MyPoint(17, 19);
	    System.out.println(point);
        System.out.println("" + point.x + ", " + point.y());
        
        
	    MyPoint point2 = new MyPoint(17, 19);
	    if (point.equals(point2))
	    {
	    	System.out.println("GLEICHE WERTEBELEGUNG");
	    }
	    else
	    {
	    	System.out.println("NOT EQUAL");
	    }	    	
	}

	@Override
	public String toString() {
		return "[x: " + x + " / y: " + y + "]";
	}	
	
	/* DO NOT TRY IT AT HOME
	@Override
	public boolean equals(Object other) {
		return false;
	}
	*/
}
