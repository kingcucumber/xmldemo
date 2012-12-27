package com.xml.dom;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomDemo {
	public static void createXml(String fileName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("students"); // create the
																// root element.
			document.appendChild(root);
			Element student = document.createElement("student");

			Element name = document.createElement("name");
			Node alice = document.createTextNode("alice");
			name.appendChild(alice);
			student.appendChild(name);
			
			Element gender = document.createElement("gender");
			Node female = document.createTextNode("female");
			gender.appendChild(female);
			student.appendChild(gender);
			
			Element email = document.createElement("email");
			Node emailNode = document.createTextNode("123@gmail.com");
			email.appendChild(emailNode);
			student.appendChild(email);
			root.appendChild(student);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new FileOutputStream(
					fileName));
			transformer.transform(source, result);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void parseXml() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse("src/book.xml");
			Element root = document.getDocumentElement(); // get the root
															// element
			NodeList childNodes = root.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node node = childNodes.item(i);
				if ("书".equals(node.getNodeName())) {
					// System.out.println(node.getBaseURI());
					NodeList childNodess = node.getChildNodes();
					for (int j = 0; j < childNodess.getLength(); j++) {
						Node nodei = childNodess.item(j);
						System.out.println(nodei.getTextContent());
						// System.out.println(nodei.getNodeName() + "=" +
						// nodei.getNodeValue());
					}
				}
			}
			// System.out.println(root.getTagName());
			// System.out.println(root.getNodeName());

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
	public static void main(String []args){
		//DomDemo.createXml("src/student.xml");
		DomDemo.parseXml();
	}
}
