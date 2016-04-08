package com.js.xml.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class ChannelMarshal {

	public static void main(String[] args) throws SAXException, JAXBException, FileNotFoundException {
		
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = factory.newSchema(new StreamSource(new File("zaneacademy.xsd")));
		
		JAXBContext context = JAXBContext.newInstance(Channel.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setSchema(schema);
		
		List<String> tutorials = new ArrayList<String>();
		tutorials.add("Object Oriented Programming");
		Topic topic = new Topic(tutorials);
		Channel channel = new Channel("BBC", topic);
		
		JAXBElement<Channel> element = new JAXBElement<Channel>(new QName("tns:channel"), Channel.class, channel);
		
		marshaller.marshal(element, new FileOutputStream(new File("zane.xml")));
	}

}
