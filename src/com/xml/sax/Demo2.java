package com.xml.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


public class Demo2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser sp = factory.newSAXParser();
		
		XMLReader reader = sp.getXMLReader();
		
		reader.setContentHandler(new ListHandler());
		
		reader.parse("src/book.xml");
	}
}

class TagValueHandler extends DefaultHandler{
	
	private String currentTag ; //record the current tag

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		
		if("����".equals(currentTag)){
			System.out.println(new String());
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		
		currentTag = qName;
	}
	
}
