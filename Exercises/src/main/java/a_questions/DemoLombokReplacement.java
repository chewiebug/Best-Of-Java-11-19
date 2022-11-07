package a_questions;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class DemoLombokReplacement
{
    private final String name;
    private LocalDate birthday;
    private int pinCode;
    
    public static void main(String[] args)
    {
        
    }

    public DemoLombokReplacement(String name, LocalDate birthday, int pinCode)
    {
        this.name = name;
        this.birthday = birthday;
        this.pinCode = pinCode;
    }

    public String getName()
    {
        return name;
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }

    public int getPinCode()
    {
        return pinCode;
    }

    public void setPinCode(int pinCode)
    {
        this.pinCode = pinCode;
    }

    // equals() & hashCode()
        
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
        DemoLombokReplacement other = (DemoLombokReplacement) obj;
        return Objects.equals(birthday, other.birthday) && Objects.equals(name, other.name) && pinCode == other.pinCode;
    }
    

    
}
