package de.java17;

import java.util.List;

import javax.swing.JOptionPane;

import com.google.common.base.Joiner;

/*
jpackage --input target/  --name JPackageDemoAppV2 --main-jar PackagingDemoExamples-1.0.0-SNAPSHOT.jar --main-class de.java17.ApplicationExample --type dmg
*/
public class ApplicationExample {

	public static void main(String[] args) {
		
		System.out.println("First JPackage");
		
		Joiner joiner = Joiner.on(":");
		String result = joiner.join(List.of("Michael", "mag", "Python"));
		System.out.println(result);
		
		JOptionPane.showConfirmDialog(null, result);
	}
}
