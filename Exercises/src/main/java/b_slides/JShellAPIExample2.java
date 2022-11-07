package b_slides;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
class JShellAPIExample2 
{
	public static void main(final String[] args) 
	{
		final JShell jshell = JShell.create();
		final List<SnippetEvent> result1 = jshell.eval("var name = \"Mike\";");
		// "cos(27) * sin(100) * 4711" => "Math.cos(27) ..."
		//final List<SnippetEvent> result1 = jshell.eval("var result = Math.cos(27) * Math.sin(100);");
		
		for (final SnippetEvent se : result1)
		{
			System.out.println(se);
			System.out.println(se.snippet());
			System.out.println(se.value());
			
			// leider kein (direkter) Zugriff auf Wert, nur über varValue()
			jshell.variables().map(varSnippet -> "variable: '" + varSnippet.name() + "' / " +
			                                     "type: " + varSnippet.typeName() + "' / " +
			                                     "value: " + jshell.varValue(varSnippet))
			               .forEach(System.out::println);
		}
		
	
		try (JShell js = JShell.create()) 
		{		
			// Achtung: Hier ist das Semikolon nötig, sonst inkrorekte Auswertung
			String valA = js.eval("int a = 42;").get(0).value();
			System.out.println("valA = " + valA);
			String valB = js.eval("int b = 7;").get(0).value();
			System.out.println("valB = " + valB);
			
			String result = js.eval("int result = a / b;").get(0).value();
			System.out.println("result = " + result);
						
			js.variables().map(varSnippet -> varSnippet.name() + " => " + varSnippet.source()).forEach(System.out::println);
		}
	}
}