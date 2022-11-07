package a_questions;

import java.util.Optional;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class OptionalOrDotOrChainExample 
{
	public static void main(String[] args) {
	
		OptionalOrDotOrChainExample s = new OptionalOrDotOrChainExample();
		
		// OR.OR
		System.out.println("DOT");
		System.out.println("---");

		System.out.println(s.or_dot_or_empty_result_result(4711));
		System.out.println(s.or_dot_or_empty_empty_result(4711));

		// OR_CHAIN
		System.out.println("CHAINING");
		System.out.println("--------");

		System.out.println(s.or_chain_or_empty_result_result(4711));
		System.out.println(s.or_chain_or__empty_empty_result(4711));
	}
	
	private Optional<String> or_dot_or_empty_result_result(final int customerId)
	{
	    return find1(customerId)
	           .or(() -> find2s(customerId))
	           .or(() -> find3s(customerId));
	}

	private Optional<String> or_dot_or_empty_empty_result(final int customerId)
	{
	    return find1(customerId)
	           .or(() -> find2e(customerId))
	           .or(() -> find3s(customerId));
	}
	
	
	
	private Optional<String> or_chain_or_empty_result_result(final int customerId)
	{
	    return find1(customerId)
	           .or(() -> find2s(customerId).or(() -> find3s(customerId)));
	}

	private Optional<String> or_chain_or__empty_empty_result(final int customerId)
	{
	    return find1(customerId)
	           .or(() -> find2e(customerId).or(() -> find3s(customerId)));
	}
	
	
	
	Optional<String> find1(int id)
	{
		return Optional.empty();
	}
	
	Optional<String> find2s(int id)
	{
		System.out.println("find2s");
		return Optional.of("RESULT 2");
	}

	Optional<String> find2e(int id)
	{
		System.out.println("find2e");
		return Optional.empty();
	}

	Optional<String> find3s(int id)
	{
		System.out.println("find3s");
		return Optional.of("RESULT 3");
	}

	Optional<String> find3e(int id)
	{
		System.out.println("find3e");
		return Optional.empty();
	}
}

