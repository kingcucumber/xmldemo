package com.xml.jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class JdomDemo {
	public static void createXml() {
		try {

			Element root = new Element("authors");
			Document document = new Document(root);
			Element author1 = new Element("author");
			Element name1 = new Element("name");
			name1.setText("turing");
			Element contribution1 = new Element("contribution");
			contribution1.setText("Turing Machine");

			Element author2 = new Element("author");
			Element name2 = new Element("name");
			name2.setText("Von Neumann");
			Element contribution2 = new Element("contribution");
			contribution2.setText("ENIAC");

			author1.addContent(name1);
			author1.addContent(contribution1);
			author2.addContent(name2);
			author2.addContent(contribution2);
			root.addContent(author1);
			root.addContent(author2);
			document.setRootElement(root);
			XMLOutputter out = new XMLOutputter();
			out.output(document, new FileOutputStream("src/authors.xml"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void parseXml() {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = builder.build(new File("src/book.xml"));
			Element root = document.getRootElement();
			List<Element> list = root.getChildren();
			for (Element element : list) {
				System.out.println("<书名>" + element.getChildText("书名")
						+ "<书名/>");
				System.out.println("<作者>" + element.getChildText("作者")
						+ "<作者/>");
				System.out.println("<售价>" + element.getChildText("售价")
						+ "<售价/>");
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//JdomDemo.createXml();
		JdomDemo.parseXml();
	}
}
