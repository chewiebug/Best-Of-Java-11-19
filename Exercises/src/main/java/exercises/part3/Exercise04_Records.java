package exercises.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise04_Records 
{
	class Square
	{
		public final double sideLength;

		public Square(final double sideLength)
		{
			this.sideLength = sideLength;
		}
	}

	record SquareRecord(double sideLength) {
	}
	
	class Circle
	{
		public final double radius;

		public Circle(final double radius)
		{
			this.radius = radius;
		}
	}

	record CircleRecord(double radius) {
	}
}
