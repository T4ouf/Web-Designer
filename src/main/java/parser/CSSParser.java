package parser;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public abstract class CSSParser {

	//@note : ATTENTION LES SELECTEURS PEUVENT ETRE RECURSIFS 
	
	public static CSSFile ParseCSS(String path) {
		CSSFile res = null;
		
		try {
			res =  new CSSFile(path);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return null;
		}
		
		//We remove useless
		String content = res.getCleanCSSContent();
		
		//TODO : parse data into the structure
		
		return res;
	}
	
	public static void writeToFile(CSSFile css, String destinationPath) throws IOException {
		
		//We push the string to the file
		FileWriter writer = new FileWriter(destinationPath);
		writer.write(css.toString());
		writer.close();
		
	}
	
}
