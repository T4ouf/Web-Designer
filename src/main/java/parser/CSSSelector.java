package parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class CSSSelector {

	public String selectorName;	//name "as written" in the css file (including '.' '#' etc.)
	//public String selectorType; //class? id? HTMLmarkup? etc.
	public HashMap<String, String> properties; //propertyName -> value
	
	public CSSSelector(String selectorName, Optional<String> selectorType) {
		this.selectorName = selectorName;
		properties = new HashMap<String, String>();
	}
	
	public CSSSelector(String selectorName, String cssRuleProperties) {
		this.selectorName = selectorName;
		this.properties = new HashMap<String, String>();
		addProperties(cssRuleProperties);
	}
	
	//function that modifies (no check) some css properties to the current selector (alias of the addProperty function)
	public void modifyProperties(String writenProperties) {
		addProperties(writenProperties);
	}
	
	//function that adds some css properties to the current selector
	public void addProperties(String writenProperties) {
		
		String[] propertyArray = writenProperties.split(";"); //we split the string on each property
		for(String property : propertyArray) {
			
			String[] splitProperty = property.split(":"); //split property name and value
			
			//TODO : Sanity check on CSS property name
			//
			//if(isValidPropertyName(splitProperty[0])){
			properties.put(splitProperty[0], splitProperty[1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
			
	}
	
}
