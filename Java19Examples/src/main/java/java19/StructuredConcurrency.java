package java19;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import jdk.incubator.concurrent.*;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 *
 * <ul>
 *     <li>Compile the program with javac --release XX --enable-preview --add-modules jdk.incubator.concurrent StructuredConcurrency.java and
 *        run it with java --enable-preview --add-modules jdk.incubator.concurrent StructuredConcurrency</li>
 *        <li>
 *             When using the source code launcher, run the program with java --source XX --enable-preview --add-modules jdk.incubator.concurrent StructuredConcurrency.java
 *        </li>
 *        <li>
 *            When using jshell, start it with jshell --enable-preview --add-modules jdk.incubator.concurrent
 *        </li>
 * </ul>
 */
public class StructuredConcurrency
{
    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        System.out.println("Start");

        System.out.println("sync:" + handleSynchronously(4711L));
        System.out.println("old style:" + handleOldStyle(4711L));
        System.out.println("new style:" + handle(4711L));

        System.out.println("End");
    }

    static Response handleSynchronously(Long userId)
    {
        String user = findUser(userId);
        Integer order = fetchOrder(userId);

        return new Response(user, order);
    }

    static Response handleOldStyle(Long userId) throws ExecutionException, InterruptedException
    {
        var exectuorService = Executors.newCachedThreadPool();

        var userNameFuture = exectuorService.submit(() -> findUser(userId));
        var orderNoFuture = exectuorService.submit(() -> fetchOrder(userId));

        var user = userNameFuture.get();   // Join findUser
        var order = orderNoFuture.get();  // Join fetchOrder

        return new Response(user, order);
    }

    static Response handle(Long userId) throws ExecutionException, InterruptedException
    {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var userNameFuture  = scope.fork(() -> findUser(userId));
            var orderNoFuture = scope.fork(() -> fetchOrder(userId));

            scope.join();          // Join both forks
            scope.throwIfFailed(); // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
            return new Response(userNameFuture.resultNow(), orderNoFuture.resultNow());
        }
    }

    static String findUser(Long userId)
    {
        return "Michael";
    }

    static Integer fetchOrder(Long userId)
    {
        return 42;
    }
    record Response(String userName, Integer orderNo) { }
}
