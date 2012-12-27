package com.xml.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jDemo {
	public static void createXml(String fileName) {
		Document document = DocumentHelper.createDocument();
		Element employees = document.addElement("employees");
		Element employee = employees.addElement("employee");
		Element name = employee.addElement("name");
		name.setText("jobs"	);
		Element age = employee.addElement("age");
		age.setText("24");
		Element employee1 = employees.addElement("employee");
		Element name1 = employee1.addElement("name");
		name1.setText("steven");
		Element age1 = employee1.addElement("age");
		age1.setText("39");
		try {
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void parseXml() {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("src/book.xml"));
			// Document document = DocumentHelper.parseText()
			Element root = document.getRootElement();
		//	System.out.println(root.getName());
			Iterator it = root.elementIterator();
			while (it.hasNext()) {
				Element e = (Element) it.next();
				for(Iterator i=e.elementIterator(); i.hasNext();){
					Element node = (Element) i.next();
					System.out.println(node.getText());
				}
			}
			System.out.println("the file ends!");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//Dom4jDemo.createXml("src/employee.xml");
		Dom4jDemo.parseXml();
		
	}
}
