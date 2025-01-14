package solutions.part3;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class Exercise02_TextBlocks 
{
	public static void main(final String[] args) 
	{
		String testAlign = """
						     ALIGNED
						       bbbb
						       CCC
						   """;
		System.out.println(testAlign);
		
		String multiLineStringOld = "THIS IS\n" +
	            "A MULTI\n" +
	            "LINE STRING\n" +
	            "WITH A BACKSLASH \\\n";
			System.out.println(multiLineStringOld);

		String multiLineString = """
                                 THIS IS
                                 A MULTI
                                 LINE STRING
                                 WITH A BACKSLASH \\
                                 """;
		System.out.println(multiLineString);
			
		String multiLineHtmlOld = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>";
		System.out.println(multiLineHtmlOld);

		String multiLineHtml = """
              <html>
                <body>
                    <p>Hello, world</p>
                </body>
              </html>
              """;
		System.out.println(multiLineHtml);
		
		String javaScriptObjOld = ""
				+ "{\n"
				+ "    \"version\": \"Java13\",\n"
				+ "    \"feature\": \"text blocks\",\n"
				+ "    \"attention\": \"preview!\"\n"
				+ "}\n";
		System.out.println(javaScriptObjOld);

		String javaScriptObj = """
    	{
        	"version": "Java13",
        	"feature": "text blocks",
        	"attention": "preview!"
    	}
    	""";
		System.out.println(javaScriptObj);
	}
}
