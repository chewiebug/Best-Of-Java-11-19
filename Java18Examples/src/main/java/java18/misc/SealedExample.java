package java18.misc;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class SealedExample
{
    static abstract sealed class BooleanExpression permits XORExpression, EqualsExpression
    {
        public void check(BooleanExpression bexp)
        {
            switch (bexp)
            {
                case XORExpression x -> System.out.println("XORExpression");
                case EqualsExpression e -> System.out.println("EqualsExpression");
            }
        }
    }

    static final class XORExpression extends BooleanExpression
    {
    }

    static final class EqualsExpression extends BooleanExpression
    {
    }

    public static void main(final String[] args)
    {
        final BooleanExpression base = new EqualsExpression();
        base.check(new EqualsExpression());
        base.check(new XORExpression());
    }
}

