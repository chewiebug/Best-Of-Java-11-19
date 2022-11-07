package java18.reflection;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das 
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class ReflectionExample
{
    public static void main(final String[] args) throws ReflectiveOperationException
    {
        accessFieldOldStyle("Java 18 Rocks");
        accessFieldNewStyle("Java 18 Rocks");
    }

    private static void accessFieldOldStyle(String input) throws ReflectiveOperationException
    {
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);

        // Exception java.lang.reflect.InaccessibleObjectException: Unable to 
        // make field private final byte[] java.lang.String.value accessible: 
        // module java.base does not "opens java.lang" to unnamed module @484b61fc
        byte[] byteValues = (byte[]) field.get(input);
        System.out.println(Arrays.toString(byteValues));
    }

    private static void accessFieldNewStyle(String input) throws ReflectiveOperationException
    {
        Lookup lookup = MethodHandles.privateLookupIn(String.class, MethodHandles.lookup());
        VarHandle handle = lookup.findVarHandle(String.class, "value", byte[].class);

        // Exception java.lang.reflect.InaccessibleObjectException: Unable to 
        // make field private final byte[] java.lang.String.value accessible: 
        // module java.base does not "opens java.lang" to unnamed module @484b61fc
        byte[] byteValues = (byte[]) handle.get(input);

        System.out.println(Arrays.toString(byteValues));
    }
}