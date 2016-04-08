package com.js.xml.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id", "questionName", "answers"})
public class Question {

	private long id;
	private String questionName;
	private List<Answer> answers;
	
	public Question() {}
	
	public Question(long id, String questionName, List<Answer> answers) {
		super();
		this.id = id;
		this.questionName = questionName;
		this.answers = answers;
	}

	@XmlAttribute
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@XmlElement
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	@XmlElement
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
	
}
