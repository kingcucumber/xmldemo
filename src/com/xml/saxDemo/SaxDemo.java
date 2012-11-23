package com.xml.saxDemo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class SaxDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser sp = factory.newSAXParser();
		
		XMLReader reader = sp.getXMLReader();
		
		reader.setContentHandler(new ListHandler());
		
		reader.parse("src/book.xml");
	}
}

class ListHandler implements ContentHandler{

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
		System.out.println(new String(ch,start,length));
		
	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("</" + qName + ">");
		
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("<" + qName + ">");
		
		for(int i = 0 ;atts != null &&i < atts.getLength();i++){
			String attName = atts.getQName(i);
			String attValue = atts.getValue(i);
			System.out.println(attName + "=" + attValue);
		}
		
	}

	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
