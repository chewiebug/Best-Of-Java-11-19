package java18.inet;

import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class OwnInetAddressResolverProvider extends InetAddressResolverProvider
{
    @Override
    public InetAddressResolver get(Configuration configuration)
    {
        return new OwnInetAddressResolver();
    }

    @Override
    public String name()
    {
        return "Own Internet Address Resolver Provider";
    }
}