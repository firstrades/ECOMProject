package com.js.xml.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

public class ProductMarshal {

	public static void main(String[] args) throws JAXBException, SAXException, FileNotFoundException {
		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new StreamSource(new File("Product.xsd")));
		
		JAXBContext context = JAXBContext.newInstance(Products.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setSchema(schema);
		
		AllProducts allProducts = new AllProducts();
		JAXBElement<AllProducts> jaxbElement = new JAXBElement<AllProducts>(new QName("js:AllProducts"), AllProducts.class, allProducts);		
		
		marshaller.marshal(jaxbElement, new FileOutputStream(new File("Product.xml")));
	}

}
