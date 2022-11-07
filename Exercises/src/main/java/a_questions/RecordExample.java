package a_questions;

import java.util.List;
import java.util.Set;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class RecordExample {

	public static void main(String[] args) {
		        
		MyPoint point = new MyPoint(17, 19);
		System.out.println("" + point.x() + ", " + point.y());	
		
		
		var points = List.of(new MyPoint(2, 3), new MyPoint(5, 7), new MyPoint(11, 13));
		System.out.println(points);
		
		var pointSet = Set.of(new MyPoint(2, 3), new MyPoint(5, 7), new MyPoint(11, 13));
        System.out.println(points);
        
		System.out.println(points.contains(new MyPoint(5, 7)));
		System.out.println(pointSet.contains(new MyPoint(47, 11)));
	}
}
