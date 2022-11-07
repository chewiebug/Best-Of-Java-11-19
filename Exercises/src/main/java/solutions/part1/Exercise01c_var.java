package solutions.part1;

import java.util.ArrayList;
import java.util.List;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise01c_var 
{
	public static void main(String[] args) 
	{
		funWithVar();
	}

	static void funWithVar()
	{
		List<String> names = new ArrayList<>(); // Achtung: nicht direkt durh var ersetzbar
		var names1 = new ArrayList<String>();   // erfordert das einfügen ds Typs auf der rechten Seite
		var names2 = new ArrayList<String>();
	}
}
