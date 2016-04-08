package com.js.jaxb.xsd;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.danibuiza.jaxb.ultimate.business.Country;

public class JAXBErrorHandler {

	public static void main(String[] args) throws Exception {
		
		/**
         * error will be thrown because continent is mandatory
         */
        Country spain = new Country();
        spain.setName( "Spain" );
        spain.setCapital( "Madrid" );
        spain.setFoundation( LocalDate.of( 1469, 10, 19 ) );
        spain.setContinent( "Europe" );

        /**
         * ok
         */
        Country australia = new Country();
        australia.setName( "Australia" );
        australia.setCapital( "Camberra" );
        australia.setFoundation( LocalDate.of( 1788, 01, 26 ) );
        australia.setContinent( "Oceania" );
        
        /**
         * schema is created
         */
        SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema( new File( "countries_validation1.xsd" ) );
        
        /**
         * context is created and used to create sources for each country
         */
        JAXBContext jaxbContext = JAXBContext.newInstance( Country.class );
        JAXBSource spainSource = new JAXBSource(jaxbContext, spain);
        JAXBSource australiaSource = new JAXBSource(jaxbContext, australia);
        
        /**
         * validator is initialized
         */
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler());
        
        try {
			validator.validate(spainSource);
			System.out.println( "spain has no problems" );
		} catch (SAXException e) {			
			e.printStackTrace();
			System.out.println( "spain has no problems" );
		}
        
        try {
			validator.validate(australiaSource);
			System.out.println( "australia has no problems" );
		} catch (SAXException e) {			
			e.printStackTrace();
			System.out.println( "australia has no problems" );
		}
	}

}
