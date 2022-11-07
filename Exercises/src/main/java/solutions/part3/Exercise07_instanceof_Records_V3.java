package solutions.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise07_instanceof_Records_V3 
{
	// Verbesserung durch Anwenden von Polymorphie und Nutzen des Basistyps in der Signatur
	public double computeArea(final BaseFigure figure) 
	{
		return figure.calcArea();
	}
	
	
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

	// Rectangle
	record Rectangle(double width, double height) implements BaseFigure {

		@Override
		public double calcArea() {
			return width * height;
		}
	}
}
