package a_questions;

import java.util.Objects;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public record RecordEqualsExample(String name, int age)
{
    // ACHTUNG: DO NOT DO IT AT HOME :-)
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecordEqualsExample other = (RecordEqualsExample) obj;
        return Objects.equals(name, other.name);
    }

    public static void main(String[] args)
    {
        var p1 = new RecordEqualsExample("Peter", 72);
        var p2 = new RecordEqualsExample("Peter", 27);
        
        System.out.println(p1.equals(p2));
    }
}
