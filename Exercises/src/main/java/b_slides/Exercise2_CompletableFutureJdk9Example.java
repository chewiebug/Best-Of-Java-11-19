package b_slides;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise2_CompletableFutureJdk9Example
{
    public static void main(final String[] args) throws ExecutionException
    {        
        CompletableFuture.failedFuture(new IllegalStateException())
        .exceptionally(ex -> { System.out.println("ALWAYS FAILING"); return -1;});
        
        CompletableFuture.supplyAsync(() -> longRunningCreateMsg(15))
                         .orTimeout(10, TimeUnit.SECONDS)
                         .exceptionally(ex -> "exception occurred: " + ex)
                         .thenAccept(Exercise2_CompletableFutureJdk9Example::notifySubscribers);
        
        CompletableFuture.supplyAsync(() -> longRunningCreateMsg(15))
                         .completeOnTimeout("TIMEOUT-FALLBACK", 2, TimeUnit.SECONDS)
                         .thenAccept(Exercise2_CompletableFutureJdk9Example::notifySubscribers);    
                           
        // Give Completablefutures the chance to complete
        sleepInSeconds(10);
    }

    public static String longRunningCreateMsg(final int durationInSecs)
    {
        System.out.println(getCurrentThread() + " >>> longRunningCreateMsg");
        sleepInSeconds(durationInSecs);
        System.out.println(getCurrentThread() + " <<< longRunningCreateMsg");

        return "longRunningCreateMsg";
    }

    public static String getCurrentThread()
    {
        return Thread.currentThread().getName();
    }

    public static void notifySubscribers(final String msg)
    {
        System.out.println(getCurrentThread() + " notifySubscribers: " + msg);
    }

    private static void sleepInSeconds(final int durationInSeconds)
    {
        try
        {
            TimeUnit.SECONDS.sleep(durationInSeconds);
        }
        catch (InterruptedException e)
        {
            /* not possible here */ }
    }
}
