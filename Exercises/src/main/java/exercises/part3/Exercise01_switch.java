package exercises.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01_switch 
{
	public static void main(String[] args) {

		int value = 7;

		evenOddCheckerDumb(value);
	}

	private static void evenOddCheckerDumb(int value) {
		String result;

		switch (value) {
		case 1, 3, 5, 7, 9:
			result = "odd";
			break;

		case 0, 2, 4, 6, 8, 10:
			result = "even";
			break;

		default:
			result = "only implemented for values < 10";
		}

		System.out.println("result: " + result);
	}

	private String evenOddCheckerArrow(int value) {

		return switch (value) {
			case 1, 3, 5, 7, 9 -> "odd";
			case 0, 2, 4, 6, 8, 10 -> "even";
			default -> "only implemented for values < 10";
		};
	}

	private String evenOddCheckerYield(int value) {

		return switch (value) {
			case 1, 3, 5, 7, 9:
				yield "odd";
			case 0, 2, 4, 6, 8, 10:
				yield "even";
			default:
				yield "only implemented for values < 10";
		};
	}

}
