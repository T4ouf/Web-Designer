package parser;

import java.io.IOException;
import java.util.HashMap;

public class CSSFile {

	private String path;
	private String content;
	protected HashMap<String, CSSSelector> properties = null; //selectorName -> all properties attached to the selector
		
	public CSSFile(String path) throws IOException {
		this.path = path;
		this.content = Util.readFile(path);
		properties = new HashMap<String, CSSSelector>();
		
		//first we remove comments and useless char
		String data = getCleanCSSContent();
		//then we split each selector
		String[] selectorsRules = data.split("\\}"); 
		
		//for each selector
		for(String selector : selectorsRules) {
			//we split selector name from the properties...
			String[] names = selector.split("\\{"); 
			//... then we store the date in our struct
			properties.put(names[0], new CSSSelector(names[0],names[1])); 
		}
	}

	//methods that returns the content and removes "useless" char (\n, \t, space, comments) for future manipulation
	public String getCleanCSSContent() {
		//first regex remove all comments
		//second regex remove all spaces/tab/new line
		return getCleanCSSContent(this.content);
	}
	
	public static String getCleanCSSContent(String content) {
		//first regex remove all comments
		//second regex remove all spaces/tab/new line
		return content.replaceAll("\\/\\*(\\*(?!\\/)|[^*])*\\*\\/", "")
						.replaceAll("\\s", "");
	}
	
	public void addProperties(String cssSelector, String writenProperties) {
		
		if(properties.containsKey(cssSelector)) {
			properties.get(cssSelector).addProperties(writenProperties);
		}
		else {
			System.err.println(cssSelector + " CSS selector does not exist in this file !");
		}
		
	}
	
	@Override
	public String toString() {
		String res = "";
		
		//We translate the data structure into a valid CSS string :
		//first we split each selector
		for(String selector : this.properties.keySet()) {
			
			res += (selector + "{");
			
			//get all the properties and their associated values
			HashMap<String,String> properties = this.properties.get(selector).properties;
			
			for(String property : properties.keySet()) {
				res += "\n\t" + property + ":" + properties.get(property) + ";";
			}
			
			res += "\n}\n";
		}
		
		return res;
	}

	public static void main(String[] args) throws IOException {
		CSSFile file = new CSSFile("./deps/Website_example/structure.css");
		//System.out.println(file.getCleanCSSContent());
		System.out.println(file);
		
	}
	
}
