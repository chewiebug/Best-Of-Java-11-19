package java18.misc;

import javax.lang.model.SourceVersion;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class Java18RuntimeVersionExample
{
    public static void main(String[] args)
    {
        System.out.println("Runtime required for this: " + SourceVersion.RELEASE_18.runtimeVersion());
        System.out.println("latest: " + SourceVersion.latest());
        System.out.println("valueOf: " + SourceVersion.valueOf("RELEASE_17"));
    }
}