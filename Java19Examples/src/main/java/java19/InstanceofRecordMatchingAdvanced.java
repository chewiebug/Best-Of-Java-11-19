package java19;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class InstanceofRecordMatchingAdvanced
{    
    record Point(int x, int y) {}
    
    enum Color { RED, GREEN, BLUE }
    record ColoredPoint(Point p, Color c) {}
    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

    static void printColorOfUpperLeftPoint(Rectangle rect) 
    {
        if (rect instanceof Rectangle(ColoredPoint(Point p, Color c), ColoredPoint lr))
        {
            System.out.println(c);
        }
    }

    static void printXCoordOfUpperLeftPointWithPatterns(Rectangle rect) 
    {
        if (rect instanceof Rectangle(ColoredPoint(Point(var x, var y), var color),
                                      var lr)) 
        {
             System.out.println("Upper-left corner x and color: " + x + " / "  + color);
        }
    }

    public static void main(String[] args) 
    {
        ColoredPoint ul = new ColoredPoint(new Point(1, 2), Color.RED);
        ColoredPoint lr = new ColoredPoint(new Point(4, 3), Color.BLUE);

        printColorOfUpperLeftPoint(new Rectangle(ul, lr));
        printXCoordOfUpperLeftPointWithPatterns(new Rectangle(ul, lr));
    }
}

