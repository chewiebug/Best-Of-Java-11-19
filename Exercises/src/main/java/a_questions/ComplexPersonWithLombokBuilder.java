package a_questions;

import java.time.LocalDate;

/*
 * Eine Person mit zb. 16 Felder wie firstname, surname, age, height, weight, addressStreet, addressNumber etc. kann ich
 * mit Records nur so instanziiren: Person john = new Person(“John”, “Smith”, 16, 170, 90, “Mullstrasse”, 16, ...);
 */
/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
//@Builder
public record ComplexPersonWithLombokBuilder(String firstname, String surname, LocalDate birthday, int height,
                                             int weight, String addressStreet, String addressNumber, String city)
{    
    /* GEHT NICHT, wenn default ctor
    @Builder
    public ComplexPersonWithLombokBuilder()
    {
    }
*/
  
    /*
    @Builder
    public ComplexPersonWithLombokBuilder
    {
    }
  */
    
    /* with Lombok enabled
    public static void main(String[] args)
    {
        var cp = ComplexPersonWithLombokBuilder.builder().surname("Peter").height(197).weight(101).addressStreet("no way").build();
        System.out.println(cp);
    }
    */
}