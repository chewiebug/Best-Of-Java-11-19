package a_questions;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class VarSpecial {

	public static void main(String[] args) {

		Runnable runner1 = new Runnable() {
			public final String info = "INACCESSIBLE";

			@Override
			public void run() {
			}
			
			public String getInfo()
			{
				return "OTHER INFO";
			}
		};
//		System.out.println(runner1.info);
//		System.out.println(runner1.getInfo());

		
		var runner2 = new Runnable() {
			public final String info = "ACCESSIBLE WITH VAR";

			@Override
			public void run() {
			}
			
			public String getInfo()
			{
				return "OTHER INFO WITH VAR";
			}
		};
		System.out.println(runner2.getClass());
		System.out.println(runner2.info);
		System.out.println(runner2.getInfo());					
	}
}
