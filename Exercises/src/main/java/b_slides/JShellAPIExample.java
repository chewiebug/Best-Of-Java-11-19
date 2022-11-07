package b_slides;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import jdk.jshell.VarSnippet;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die
 * Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 *         Copyright 2021/2022 by Michael Inden
 */
class JShellAPIExample {
	public static void main(final String[] args) {
		final JShell jshell = JShell.create();
		final List<SnippetEvent> result1 = jshell.eval("var name = \"Mike\";");
		// "cos(27) * sin(100) * 4711" => "Math.cos(27) ..."
		// final List<SnippetEvent> result1 = jshell.eval("var result = Math.cos(27) *
		// Math.sin(100);");

		for (final SnippetEvent se : result1) {
			System.out.println(se);
			System.out.println(se.snippet());
			System.out.println(se.value());

			// leider kein (direkter) Zugriff auf Wert, nur über varValue()
			jshell.variables().forEach(snippet -> printVarInfo(jshell, snippet));			                   
		}

		simpleMathCalc();
	}

	private static void simpleMathCalc() 
	{
		try (JShell js = JShell.create()) {
			// Achtung: Hier ist das Semikolon nötig, sonst inkrorekte Auswertung
			js.eval("int a = 42;");
			js.eval("int b = 7;");
	
			String result = js.eval("int result = a / b;").get(0).value();
			System.out.println("result = " + result);
	
			js.variables().forEach(snippet -> printVarInfo(js, snippet));			   
		}
	}

	private static void printVarInfo(final JShell jshell, 
			                         final VarSnippet varSnippet) 
	{
		System.out.println("variable: '" + varSnippet.name() + 
			               "' / " + "type: " + varSnippet.typeName() + 
			               "' / " + "value: " + jshell.varValue(varSnippet));
	}
}