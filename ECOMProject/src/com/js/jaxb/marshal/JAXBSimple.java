package com.js.jaxb.marshal;

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.js.jaxb.business.Country;

public class JAXBSimple {

	public static void main(String[] args) {
		
		Country spain = new Country();
		spain.setCapital("Madrid");
		spain.setContinent("Europe");
		spain.setFoundation(LocalDate.of(1469, 10, 19));
		spain.setName("Spain");
		spain.setPopulation(45000000);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(spain, new File("country1.xml"));
			marshaller.marshal(spain, System.out);
		} catch (JAXBException e) {			
			e.printStackTrace();
		}
	}

}
