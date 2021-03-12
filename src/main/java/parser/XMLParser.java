package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import dataStructures.Palet;


public class XMLParser {
	
	private XMLInputFactory xmlif = null;
	
	
	/**
	 * Constructor for the XML parser
	 */
	public XMLParser() {
		xmlif = XMLInputFactory.newInstance();
	}
	
	/**
	 * Function to parse a palet from an XML file into the web-designer
	 * @param path, the path to the XML palet
	 * @return the palet data
	 */
	public Palet ParseXMLPalet(String path){
		
		XMLStreamReader xmlReader = null;
		Palet parsedPalet = new Palet();
		
		try {
			xmlReader= xmlif.createXMLStreamReader(new FileReader(path));	
			
			int eventType;
			while (xmlReader.hasNext()) {
				eventType = xmlReader.next();
				
				//if we find an opening markup
				if(eventType==XMLEvent.START_ELEMENT) {
			
					//...and it is a palet markup...
					if(xmlReader.getName().getLocalPart().equals("palet")) {

						//we get palet data
						parsedPalet.id = Integer.parseInt(xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "id"));
						parsedPalet.name = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "name");
					
					}
					//and then parse colors
					else if(xmlReader.getName().getLocalPart().equals("Prim1")) {
						parsedPalet.colorMain1 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim2")) {
						parsedPalet.colorMain2 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim3")) {
						parsedPalet.colorMain3 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim1Var1")) {
						parsedPalet.color1Var1 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim1Var2")) {
						parsedPalet.color1Var2 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim2Var1")) {
						parsedPalet.color2Var1 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim2Var2")) {
						parsedPalet.color2Var2 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim3Var1")) {
						parsedPalet.color3Var1 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
					else if(xmlReader.getName().getLocalPart().equals("Prim3Var2")) {
						parsedPalet.color3Var2 = xmlReader.getAttributeValue(xmlReader.getNamespaceURI(), "value");
					}
				}
			}
			xmlReader.close(); //Once everything is parsed : we close the reader
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		return parsedPalet;
	}
	
	
}