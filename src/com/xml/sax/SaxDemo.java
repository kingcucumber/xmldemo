package com.xml.sax;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDemo {
	public static void main(String[] args) {
		//SaxDemo.createXml();
		SaxDemo.parseXml();
	}

	public static void createXml() {
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		TransformerHandler handler;
		try {
			handler = factory.newTransformerHandler();
			Transformer transformer = handler.getTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			FileOutputStream out = new FileOutputStream("src/computers.xml");
			Result result = new StreamResult(out);
			handler.setResult(result);
			
			handler.startDocument();
			AttributesImpl attr = new AttributesImpl();
			handler.startElement("", "", "computers", attr);

			attr.clear();
			attr.addAttribute("", "name", "name", "", "dell");
			attr.addAttribute("", "country", "country", "", "US");
			handler.startElement("", "", "dell", attr);
			handler.characters("dell's computer is  cheap!".toCharArray(), 0,
					"dell's computer is cheap!".length());
			handler.endElement("", "", "dell");

			attr.clear();
			attr.addAttribute("", "name", "name", "", "levono");
			attr.addAttribute("", "country", "country", "", "CN");
			handler.startElement("", "", "lenovo", attr);
			handler.characters("lenovo's computer is good!".toCharArray(), 0,
					"lenovo's computer is good!".length());
			handler.endElement("", "", "lenovo");
			
			handler.endElement("", "", "computers");
			handler.endDocument();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void parseXml() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser sp;
		try {
			sp = factory.newSAXParser();
			XMLReader reader = sp.getXMLReader();
			reader.setContentHandler(new MySaxHandler());
			reader.parse("src/book.xml");
			// sp.parse(new File("src/book.xml"), new MySaxHandler());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MySaxHandler extends DefaultHandler {

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(new String(ch, start, length));
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("</" + qName + ">");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("<" + qName + ">");

		for (int i = 0; attributes != null && i < attributes.getLength(); i++) {
			String attName = attributes.getQName(i);
			String attValue = attributes.getValue(i);
			System.out.println(attName + "=" + attValue);
		}
	}

}

class ListHandler implements ContentHandler {

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub

		System.out.println(new String(ch, start, length));
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("</" + qName + ">");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("<" + qName + ">");
		for (int i = 0; atts != null && i < atts.getLength(); i++) {
			String attName = atts.getQName(i);
			String attValue = atts.getValue(i);
			System.out.println(attName + "=" + attValue);
		}
	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	public void processingInstruction(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}

	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub

	}

	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {
		// TODO Auto-generated method stub

	}
}
