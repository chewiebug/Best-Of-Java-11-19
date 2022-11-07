package java19;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class SwitchWhen
{
    interface Shape {}

    record Rectangle() implements Shape {}
    record Triangle()  implements Shape { int calculateArea() { return 7271; } }

    static void testTriangleAndString(Object obj)
    {
        switch (obj)
        {
            case Triangle t when t.calculateArea() > 100 ->
                System.out.println("Large triangle");
            case String str when str.startsWith("INFO") && str.contains("SPECIAL") ->           
        		System.out.println("a very special info");
            case String str when str.startsWith("INFO") ->
                System.out.println("just an info");
            // not detected ...
            case String str when str.startsWith("INFO") && str.contains("SPECIAL") ->           
            	System.out.println("a very special info");                
            default ->
               System.out.println("Something else: " + obj);
        }
    }

    public static void main(String[] args)
    {
        testTriangleAndString(new Triangle());
        testTriangleAndString("INFO: switch and when");
        testTriangleAndString("INFO: switch and SPECIAL");
        testTriangleAndString("Michael");
    }
}
