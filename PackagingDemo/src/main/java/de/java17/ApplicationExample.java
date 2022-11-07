package de.java17;

import javax.swing.JOptionPane;

/*
jpackage --input target  --name JPackageDemoApp --main-jar PackagingDemoExamples-1.0-SNAPSHOT.jar --main-class de.java17.ApplicationExample --type dmg
 */
public class ApplicationExample {

	public static void main(String[] args) {
		
		System.out.println("First JPackage");
		
		JOptionPane.showConfirmDialog(null, "First JPackage");
	}
}
