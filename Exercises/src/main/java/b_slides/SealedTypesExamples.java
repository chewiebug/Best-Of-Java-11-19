package b_slides;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class SealedTypesExamples {
	sealed interface MathOp permits BaseOp,Add,Sub // <= erlaubte Subtypen
	{
		int calc(int x, int y);
	}

	// Mit non-sealed kann man innerhalb der Vererbungshierarchie Basisklassen
	// bereitstellen
	non-sealed class BaseOp implements MathOp // <= Basisklasse
	// nicht versiegeln
	{
		@Override
		public int calc(int x, int y) {
			return 0;
		}
	}

	final class Add implements MathOp {
		@Override
		public int calc(int x, int y) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	final class Sub implements MathOp {
		@Override
		public int calc(int x, int y) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}