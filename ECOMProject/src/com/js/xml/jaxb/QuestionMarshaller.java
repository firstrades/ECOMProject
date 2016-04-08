package com.js.xml.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class QuestionMarshaller {

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Answer answer1 = new Answer(101, "Java is a programming language.", "Rishi");
		Answer answer2 = new Answer(102, "Java is JVM language.", "Rohit");
		
		ArrayList<Answer> list = new ArrayList<Answer>();
		list.add(answer1);
		list.add(answer2);
		
		Question question = new Question(1, "What is Java?", list);
		
		marshaller.marshal(question, new FileOutputStream("question.xml"));
	}

}
