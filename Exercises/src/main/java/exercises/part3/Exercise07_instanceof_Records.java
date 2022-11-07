package exercises.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07_instanceof_Records 
{
	record Square(double sideLength) {
	}
	
	record Circle(double radius) {
	}
	
	public double computeAreaOld(final Object figure) 
	{
		if (figure instanceof Square) 
		{
			final Square square = (Square) figure;
			return square.sideLength * square.sideLength;
		} 
		else if (figure instanceof Circle) 
		{
			final Circle circle = (Circle) figure;
			return circle.radius * circle.radius * Math.PI;
		}
		throw new IllegalArgumentException("figure is not a recognized figure");
	}

}
