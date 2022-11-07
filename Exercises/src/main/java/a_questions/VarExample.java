package a_questions;

import java.util.ArrayList;
import java.util.Map;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class VarExample {

	public static void main(String[] args) {
		
	    var names = new ArrayList<String>();
		names.add("Tim");
		// names.add(72);
		
		var nameToAgeMapping = Map.of("Tim", 50, "Tom", 7);
		var entrySet = nameToAgeMapping.entrySet();
		//List.of
	}

}
