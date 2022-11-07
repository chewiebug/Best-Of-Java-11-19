package java18.webserver;

import java.net.InetSocketAddress;
import java.nio.file.Path;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class SimpleWebServerApp
{
    public static void main(final String[] args)
    {
        var address = new InetSocketAddress(8888);
        // BITTE DEN PFAD AUF DEN EIGENEN ANPASSEN
        var path = Path.of("/Users/michaelinden");
        var verbosity = OutputLevel.VERBOSE;

        var server = SimpleFileServer.createFileServer(address, path, verbosity);

        server.start();

        System.out.println("SimpleWebServerApp is up and running");        
    }
}