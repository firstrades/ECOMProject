package com.js.jaxb.marshal;

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.js.jaxb.business.Countries;
import com.js.jaxb.business.Country;

public class JAXBList {

	public static void main(String[] args) {
			
		Country spain = new Country();
		spain.setCapital("Madrid");
		spain.setContinent("Europe");
		spain.setFoundation(LocalDate.of(1469, 10, 19));
		spain.setName("Spain");		
		
		Country usa = new Country();
		usa.setCapital("Washington");
		usa.setContinent("America");
		usa.setFoundation(LocalDate.of(1776, 7, 4));
		usa.setName("USA");		
		
		Countries countries = new Countries();
		countries.add(spain);
		countries.add(usa);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(countries, new File("list_countries1.xml"));
			marshaller.marshal(countries, System.out);
		} catch (JAXBException e) {			
			e.printStackTrace();
		}
	}

}
