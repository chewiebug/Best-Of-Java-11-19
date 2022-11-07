package a_questions;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class TextBlockHelp {

    public static void main(String[] args) {
        String multiLineStringOld = """
            THIS IS
            A MULTI
            LINE STRING
            WITH A BACKSLASH \\
            """;
        System.out.println(multiLineStringOld);
    }

}
