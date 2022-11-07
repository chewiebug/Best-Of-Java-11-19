package solutions.part5;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die
 * Neuerungen in Java 17 LTS und 18"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/2022 by Michael Inden
 */
public class Exercise03_JShellCalculation 
{
	public static void main(final String args[]) 
	{
		try (JShell jshell = JShell.create()) 
		{
			jshell.eval("int x = 7;");
			jshell.eval("int y = 6;");
			List<SnippetEvent> snippetEvents = jshell.eval("int result = x * y;");
			System.out.println("Size of list: " + snippetEvents.size());
			System.out.println("Value of the expression is " + snippetEvents.get(0).value());

			jshell.eval("import java.time.*;");
			jshell.eval("var today = LocalDate.now();");

			jshell.eval("import java.util.*;");
			jshell.eval("var values = List.of(1, 2, 3, 4);");

			jshell.variables().forEach(x -> System.out.println("var:" + x.name() + "=" + jshell.varValue(x)));
			List<SnippetEvent> se = jshell.eval("""
					for (var val : values) {
					     System.out.println("val: " + val);
					}
					""");
			System.out.println("Size of list: " + se.size());
			System.out.println("source: " + se.get(0).snippet().source());
		}
	}
}