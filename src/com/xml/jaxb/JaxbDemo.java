package com.xml.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbDemo {

	public static void marshalDemo() {
		File file = new File("src/article.xml");

		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Article.class);
			Marshaller m = context.createMarshaller();

			Article article = new Article();
			article.setAuthor("josh");
			article.setDate("20121227");
			article.setEmail("123@456.com");
			article.setTitle("XML");

			m.marshal(article, file);

		} catch (JAXBException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void unmarshalDemo() {
		File file = new File("src/student.xml");
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Students.class);
			Unmarshaller u = context.createUnmarshaller();
			Students students = (Students) u.unmarshal(file);
		
			List<Student> ss = students.getList();
			System.out.println(ss.size());
			for(Student s : ss){
				System.out.println(s.getName());
				System.out.println(s.getGender());
				System.out.println(s.getEmail());
			}
				
		} catch (JAXBException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JaxbDemo.unmarshalDemo();
		// JaxbDemo.marshalDemo();
	}
}
