package java19;
import java.time.Duration;
import java.util.concurrent.Executors;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class VirtualThreads
{
    public static void main(String[] args)
    {
    	System.out.println("Start");

        try (var executor = Executors.newVirtualThreadPerTaskExecutor())
        {
            for (int  i = 0; i < 100_000; i++)
            {
                final int pos = i;
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return pos;
                });
            }
        }
        // executor.close() is called implicitly, and waits
        System.out.println("End");
    }
}
