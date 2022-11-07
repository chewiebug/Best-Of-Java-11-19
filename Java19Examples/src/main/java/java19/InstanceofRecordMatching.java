package java19;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class InstanceofRecordMatching
{
    record Point(int x, int y) {}

    static void printCoordinateInfo(Object obj)
    {
        if (obj instanceof Point point)
        {
            int x = point.x();
            int y = point.y();

            System.out.println("x: %d y: %d, sum: %d".formatted(x, y, x + y));
        }
    }

    static void printCoordinateInfoNew(Object obj)
    {
        if (obj instanceof Point(int x, int y))
        {
            System.out.println("x: %d y: %d, sum: %d".formatted(x, y, x + y));
        }
    }
    
    public static void main(String[] args)
    {
        printCoordinateInfo(new Point(72, 71));
        printCoordinateInfoNew(new Point(72, 71));
    }
}