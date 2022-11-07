package b_slides;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class FirstNullableExample {

	public static void main(final String[] args) {

		final Stream<Customer> customerStream1 = Stream.of(findCustomer());
		System.out.println(customerStream1.count());
		
		final Stream<Customer> customerStream2 = Stream.of(findCustomer());
		final Optional<Customer> optFirst = customerStream2.findFirst();
		optFirst.ifPresentOrElse(System.out::println, () -> System.out.println("No element"));
	}

	private static Customer findCustomer() 
	{
		return null;
	}
}
