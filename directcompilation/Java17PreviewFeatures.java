package does.not.count;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
import java.util.List;

public class Java17PreviewFeatures
{
    public static void main(String... args)
    {
        processData("Java");
        processData(null);
        processData(72);
    }

    static void processData(Object obj)
    {
        switch (obj)
        {
            case null -> System.out.println("null is allowed in preview");
            case String str && str.startsWith("V1") -> 
                 System.out.println("Processing V1");
            case String str && str.startsWith("V2") -> 
                 System.out.println("Processing V2");
            case String str && 
                 List.of("Java", "Python").contains(str) -> 
                 System.out.println("cool language");
            case Integer i && i > 10 && i < 100 -> 
                 System.out.println("Processing ints");
            default -> throw new IllegalArgumentException("invalid input");
        }
    }
}