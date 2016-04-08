package com.js.xml.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Channel {

	private String name;
	private Topic topic;	
	
	public Channel() {
		// TODO Auto-generated constructor stub
	}
	
	public Channel(String name, Topic topic) {
		super();
		this.name = name;
		this.topic = topic;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
