package a_questions;

import java.time.LocalDate;

/*
 * Eine Person mit zb. 16 Felder wie firstname, surname, age, height, weight, addressStreet, addressNumber etc. 
 * kann ich mit Records nur so instanziiren: 
Person john = new Person("John", "Smith", 16, 170, 90, "Mullstrasse", 16, ...); 
 */
/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public record ComplexPerson(String firstname, String surname, LocalDate birthday, int height, int weight,
                            String addressStreet, String addressNumber, String city)
{
    public static void main(String[] args)
    {
        ComplexPerson john = new ComplexPerson("John", "Smith", LocalDate.of(2010, 6,  21), 
                                               170, 90, "ullstrasse", "16a", "Berlin"); 
        
        ComplexPerson mike = new ComplexPeronBuilder().withFirstName("Mike").
                        withBirthday(LocalDate.of(2021, 1, 21)).withSurName("Peters").build();
        System.out.println(mike);          
    }   
}

// naja, Handarbeit
class ComplexPeronBuilder
{
    private String firstname;
    private String surname;
    private LocalDate birthday;
    
    public ComplexPeronBuilder()
    {}
    
    public ComplexPeronBuilder withFirstName(String firstname)
    {
        this.firstname = firstname;
        return this;
    }
    
    public ComplexPeronBuilder withSurName(String suname)
    {
        this.surname = suname;
        return this;
    }
    
    public ComplexPeronBuilder withBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
        return this;
    }
    
    public ComplexPerson build()
    {
        return new ComplexPerson(firstname, surname, birthday, 0, 0, "", "", "");
    }
}

record Address(String addressStreet, String addressNumber, String city)
{
}

record BodyInfo(int height, int weight)
{
}

record PersonDTO(String firstname, String surname, LocalDate birthday)
{
}

record ReducedComplexPerson(PersonDTO person, BodyInfo bodyInfo, Address address)
{
    public static void main(String[] args)
    {
        var john = new PersonDTO("“John", "Smith", LocalDate.of(2010, 6,  21));
        var bodyInfo = new BodyInfo(170, 90);
        var address = new Address("ullstrasse", "16a", "Berlin"); 

        var rcp = new ReducedComplexPerson(john, bodyInfo, address);
    }
}
