package solutions.part1;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise05_Optional
{
    public static void main(final String[] args)
    {
        System.out.println("findJdk8");
        findJdk8();
        System.out.println("findJdk9");
        findJdk9();
    }

    private static void findJdk9()
    {
        final Optional<Person> opt = findPersonByName("Tim");
        opt.ifPresentOrElse(person -> doHappyCase(person), () -> doErrorCase());

        final Optional<Person> opt2 = findPersonByName("UNKNOWN");
        opt2.ifPresentOrElse(person -> doHappyCase(person), () -> doErrorCase());
    }

    private static void findJdk8()
    {
        final Optional<Person> opt = findPersonByName("Tim");
        if (opt.isPresent())
        {
            doHappyCase(opt.get());
        }
        else
        {
            doErrorCase();
        }

        final Optional<Person> opt2 = findPersonByName("UNKNOWN");
        if (opt2.isPresent())
        {
            doHappyCase(opt2.get());
        }
        else
        {
            doErrorCase();
        }
    }

    private static Optional<Person> findPersonByName(final String searchFor)
    {
        final Stream<Person> persons = Stream.of(new Person("Mike"), new Person("Tim"), new Person("Tom"));

        return persons.filter(person -> person.getName().equals(searchFor)).findFirst();
    }

    private static void doHappyCase(final Person person)
    {
        System.out.println("Result: " + person);
    }

    private static void doErrorCase()
    {
        System.out.println("not found");
    }

    static class Person
    {
        private final String name;

        public Person(String name)
        {
            this.name = name;
        }

        public String getName()
        {
            return name;
        }

        @Override
        public String toString()
        {
            return "Person: " + getName();
        }
    }
}
