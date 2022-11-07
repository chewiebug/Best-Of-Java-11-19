package solutions.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07_instanceof_Records_V2 
{
	// Verbesserung durch Einführen eines Basistyps und einer Methode calcArea() 
	interface BaseFigure
	{
		double calcArea();
	}
	
	record Square(double sideLength) implements BaseFigure {

		@Override
		public double calcArea() {
			return sideLength * sideLength;
		}
	}

	record Circle(double radius) implements BaseFigure 
	{
		@Override
		public double calcArea() 
		{
			return radius * radius * Math.PI;
		}
	}
	
	public double computeArea(final Object figure) 
	{
		if (figure instanceof Square square) 
		{
			return square.calcArea();
		} 
		else if (figure instanceof Circle circle) 
		{
			return circle.calcArea();
		}
		throw new IllegalArgumentException("figure is not a recognized figure");
	}	
}
