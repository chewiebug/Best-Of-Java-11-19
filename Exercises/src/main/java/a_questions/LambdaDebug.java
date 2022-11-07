package a_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class LambdaDebug {

    public static void main(String[] args) {
        // Debugging
        Stream<String> names = Stream.of("Anne", "Peter", "John", "Mike", "Tim", "Mic", "Moni", "ABCDE");
        
        Predicate<String> strStartsWithM = str -> str.startsWith("M");
        Predicate<String> strLength4_ = str -> str.length() >= 4;
        Predicate<String> combi = strStartsWithM.or(strLength4_);

        // List<String> result = new ArrayList<>();
        List<String> result = names.filter(strStartsWithM).
            // peek(str -> System.out.println("Passed: " + str)).
            filter(str -> str.length() >= 4).
            // peek(System.out::println).
            //forEach(System.out::println);
            //forEach(elem -> result.add(elem));
            toList();
        
        System.out.println(result);
        
        // Stilistisch problematisch, da 1) nicht funktional, da Seiteneffekt
        // 2) bessere Alternative (s.u.), aber, da nur loakle Daten geändert werden, OKAY
        // NOK: falls result von außen kommt 
        List<String> result1 = new ArrayList<>();
        names.filter(strStartsWithM).
              filter(str1 -> str1.length() >= 4).
              forEach(elem -> result1.add(elem));
        // result1 = new ArrayList<>();
        
        // Stilistisch am besten
        List<String> result2 = names.filter(strStartsWithM).
                        filter(str -> str.length() >= 4).
                        toList();        
    }
}
