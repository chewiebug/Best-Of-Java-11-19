package exercises.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise02_CollectionFactoryMethodsExample 
{
    public static void main(final String[] args)
    {
    	System.out.println("Java 8");
		collectionsExampleJdk8();
		
		System.out.println("\nJava 9");
		collectionsExampleJdk9();
    }
    
    private static void collectionsExampleJdk8() 
    {
    	final List<String> names = Arrays.asList("Tim", "Tom", "Mike");
    	System.out.println(names);

        //final Set<Integer> numbers = new TreeSet<>();
        final Set<Integer> numbers = new HashSet<>();        
    	numbers.add(1);
    	numbers.add(3);
    	numbers.add(4);
    	numbers.add(2);
    	System.out.println(numbers);

    	final Map<Integer, String> mapping = new HashMap<>();
    	mapping.put(5, "five");
    	mapping.put(6, "six");
    	mapping.put(7, "seven");
    	System.out.println(mapping);
    }

	private static void collectionsExampleJdk9() 
	{
		// TODO Use Collections factory methods
	}
}

