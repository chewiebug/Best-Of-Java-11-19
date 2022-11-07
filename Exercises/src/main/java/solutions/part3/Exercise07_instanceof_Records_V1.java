package solutions.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07_instanceof_Records_V1 
{
	// Verbesserung ohne Cast, aber instancoef verstösst gegen Open Closed
	public double computeArea(final Object figure) 
	{
		if (figure instanceof Square square) 
		{
			return square.sideLength * square.sideLength;
		} 
		else if (figure instanceof Circle circle) 
		{
			return circle.radius * circle.radius * Math.PI;
		}
		throw new IllegalArgumentException("figure is not a recognized figure");
	}
	
	record Square(double sideLength) {
	}
	
	record Circle(double radius) {
	}
}
