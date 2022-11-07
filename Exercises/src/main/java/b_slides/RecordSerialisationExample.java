package b_slides;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class RecordSerialisationExample
{
    public static void main(String[] args) throws JsonProcessingException
    {
        final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        //var person = new Person("John", "Doe", "USA", LocalDate.of(1991, 3, 29), List.of("Speaker"));
        var person = new Person("John", "Doe", "USA", new Date(), List.of("Speaker"));
        //var person = new Person("John", "Doe", "USA", new Date(), List.of("Speaker"));

        var serializedJson = mapper.writeValueAsString(person);
        System.out.println(serializedJson);
        
        var person2 = new Person2("John", "Doe", "USA", LocalDate.of(1991, 3, 29), List.of("Speaker"));

        var serializedJson2 = mapper.writeValueAsString(person2);
        System.out.println(serializedJson2);       

    }
}
