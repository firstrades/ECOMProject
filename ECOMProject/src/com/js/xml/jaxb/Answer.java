package com.js.xml.jaxb;

public class Answer {

	private long id;
	private String answer;
	private String postedBy;
	
	public Answer() {}	
	
	public Answer(long id, String answer, String postedBy) {
		super();
		this.id = id;
		this.answer = answer;
		this.postedBy = postedBy;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
	
}
