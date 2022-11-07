package a_questions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Person
{
    final String name;
    
    // möglichst nicht in hashCode()
    LocalDate    birthday;
    boolean      modifed;

    public boolean isModifed()
    {
        return modifed;
    }

    public void setModifed(boolean modifed)
    {
        this.modifed = modifed;
    }

    public Person(String name, LocalDate birthday)
    {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(birthday, "birthday must not be null");

        this.name = name;
        this.birthday = birthday;
    }

    public static void main(String[] args)
    {
        Person peter = new Person("Peter", LocalDate.of(1987, 2, 14));

        Map<Person, List<String>> mapping = new HashMap<>();
        mapping.put(peter, List.of("TV", "Java", "Pizza"));

        peter.setModifed(true);
        //peter.setBirthday(LocalDate.of(1988, 2, 15));

        System.out.println(mapping.get(peter));
    }

    public String getName()
    {
        return name;
    }
    //    public void setName(String name)
    //    {
    //        Objects.requireNonNull(name, "name must not be null");
    //        this.name = name;
    //    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(birthday, other.birthday) && Objects.equals(name, other.name);
    }

}
