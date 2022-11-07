package java18.syntax;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class SwitchPreviewExample
{
    public static void main(final String[] args)
    {
        patternMatchingExample("Python");
        patternMatchingExample(null);

        //	performAction(new Add());
        //	performAction(new Sub());
    }

    static void patternMatchingExample(Object obj)
    {
        switch (obj)
        {
            case null -> System.out.println("null");
            case String str && str.length() > 5 -> System.out.println(str.strip());
            case String str -> System.out.println(str.toLowerCase());
            case Integer i -> System.out.println(i * i);
            default ->
                            {
                            }
        }
    }

    /*
     * static void dominanceExample(Object obj) { switch (obj) { case null ->
     * System.out.println("null"); case String str ->
     * System.out.println(str.toLowerCase()); case String str && str.length() > 5 ->
     * System.out.println(str.strip()); case Integer i -> System.out.println(i * i);
     * default -> {} } }
     */

    static void dominanceExample(Object obj)
    {
        switch (obj)
        {
            case null -> System.out.println("null");
            case String str && str.length() > 5 -> System.out.println(str.strip());
            case String str -> System.out.println(str.toLowerCase());
            case Integer i -> System.out.println(i * i);
            default -> { }
        }
    }

    static void dominanceExampleWithConstant(Object obj)
    {
        switch (obj.toString())
        {
            case String str && str.length() > 5 -> System.out.println(str.strip());
            //case "Sophie" -> System.out.println("My lovely daughter");
            default -> System.out.println("FALLBACK");
        }
    }

    // Demo: abstract wegnehmen
    static sealed abstract class BaseOp permits Add, Sub
    {
    }

    static final class Add extends BaseOp
    {
    }

    static final class Sub extends BaseOp
    {
    }

    static void performAction(BaseOp op)
    {
        switch (op)
        {
            case Add a -> System.out.println(a);
            case Sub s -> System.out.println(s);
            // default -> System.out.println("FALLBACK");
        }
    }
}