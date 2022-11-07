
/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class PalindromeChecker 
{
   public static void main(final String[] args) 
   {
       if (args.length < 1)
       {
          System.err.println("input is required!");
          System.exit(1);
        }
       
        System.out.printf("'%s' is a palindrome? => %b %n",
                  args[0], StringUtils.isPalindrome(args[0]));
   }
}

public class StringUtils 
{
    public static boolean isPalindrome(String word) 
    {
      return (new StringBuilder(word)).reverse().toString()
            .equalsIgnoreCase(word);
    }
}