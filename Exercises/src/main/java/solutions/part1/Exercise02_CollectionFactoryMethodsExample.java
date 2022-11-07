package solutions.part1;

import static java.util.Map.entry;

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
		// Use Collections factory methods
        final List<String> names = List.of("Tim", "Tom", "Mike");
    	System.out.println(names);

        final Set<Integer> numbers = Set.of(1, 3, 4, 2, 5, 6);
        System.out.println(numbers);
        //System.out.println(new TreeSet<>(numbers));

        final Map<Integer, String> mapping = Map.of(5, "five", 6, "six", 7, "seven");
        final Map<Integer, String> mapping2 = Map.ofEntries(entry(5, "five"), 
                                                            entry(6, "six"),
                                                            entry(7, "seven"));

    	System.out.println(mapping);
    	System.out.println(mapping2);
        mapping.forEach((key, value) -> System.out.println(key + ":" + value));
        mapping2.forEach((key, value) -> System.out.println(key + ":" + value));
	}
}

