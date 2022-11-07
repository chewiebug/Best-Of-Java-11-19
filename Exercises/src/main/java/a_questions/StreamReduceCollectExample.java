package a_questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class StreamReduceCollectExample
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum1 = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);       
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        int sum3 = numbers.stream().mapToInt(n -> n).sum();
        
        // ----------------
        
        int max = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);   
        int min = numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);   
        System.out.println("min: " + min + " / max: " + max);
        
        // ----------------
                     
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6);
        int fac1 = numbers2.stream().reduce(1, (subtotal, element) -> subtotal * element);   
        int fac2 = numbers2.stream().reduce(1, Math::multiplyExact);
        System.out.println("Fak: " + fac1 + " / " + fac2);
        
        numbers2.stream().collect(Collectors.toList());
        
        // ----------------
        
        List<Integer> ages = Arrays.asList(10, 20, 30, 40, 50, 60);
        int computedAges = ages.stream().reduce(0, (a, b) -> a + b, Integer::sum);
        System.out.println(computedAges);
        
        int computedAgesPara = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
        System.out.println(computedAgesPara);               
    }
}
