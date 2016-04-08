package com.js.xml.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class QuestionUnMarshaller {

	public static void main(String[] args) throws JAXBException {
		
		File file = new File("question.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Question question = (Question) unmarshaller.unmarshal(file);
		
		System.out.println(question.getId() + " " + question.getQuestionName());
		
		List<Answer> list = question.getAnswers();
		
		for (Answer answer : list) {
			
			System.out.println(answer.getAnswer());
		}
	}

}
