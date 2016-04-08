package com.js.xml.jaxb;

import java.util.List;

public class Topic {

	private List<String> tutorials;
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}

	public Topic(List<String> tutorials) {
		super();
		this.tutorials = tutorials;
	}

	public List<String> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<String> tutorials) {
		this.tutorials = tutorials;
	}
	
	
}
