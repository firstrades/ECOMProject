package com.js.jaxb.xsd;

import java.io.File;
import java.time.LocalDate;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.js.jaxb.business.Country;

public class WithoutValidation {

	public static void main(String[] args) throws SAXException, JAXBException {
		// countries1.xsd
		Country spain = new Country();
        spain.setName( "Spain" );
        spain.setCapital( "Madrid" );
        spain.setContinent( "Europe" );
        spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );
        spain.setPopulation( 45000000 );
        
        
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File("countries1.xsd"));
        
        JAXBContext context = JAXBContext.newInstance(Country.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setSchema(schema);
        marshaller.marshal(spain, System.out);
	}

}
