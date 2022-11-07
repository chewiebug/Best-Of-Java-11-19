package exercises.part1;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise06_Optional
{
    public static void main(final String[] args)
    {
        final Optional<String> optCustomer = multiFindCustomerJdk8("Tim");
        optCustomer.ifPresentOrElse(str -> System.out.println("found: " + str), 
                                    () -> System.out.println("not found"));

        final Optional<String> optCustomer2 = multiFindCustomerJdk9("Tim");
        optCustomer2.ifPresentOrElse(str -> System.out.println("found: " + str), 
                                     () -> System.out.println("not found"));
    }

	private static Optional<String> multiFindCustomerJdk9(final String customerId)
    {
        // TODO
        return Optional.empty();
    }
    
    private static Optional<String> multiFindCustomerJdk8(final String customerId)
    {
        final Optional<String> opt1 = findInCache(customerId);

        if (opt1.isPresent())
        {
            return opt1;
        }
        else
        {
            final Optional<String> opt2 = findInMemory(customerId);

            if (opt2.isPresent())
            {
                return opt2;
            }
            else
            {
                return findInDb(customerId);
            }
        }
    }

    private static Optional<String> findInMemory(final String customerId)
    {
        System.out.println("findInMemory");
        final Stream<String> customers = Stream.of("Tim", "Tom", "Mike", "Andy");
        
        return customers.filter(name -> name.contains(customerId))
                        .findFirst();
    }
    
    private static Optional<String> findInCache(final String customerId)
    {
        System.out.println("findInCache");
        return Optional.empty();
    }

    private static Optional<String> findInDb(final String customerId)
    {
        System.out.println("findInDb");
        return Optional.empty();
    }
}
