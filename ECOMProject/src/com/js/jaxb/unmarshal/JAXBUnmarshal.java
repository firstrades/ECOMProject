package com.js.jaxb.unmarshal;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

//import com.danibuiza.jaxb.ultimate.business.Countries;

import com.js.jaxb.business.Countries;

public class JAXBUnmarshal {

	public static void main(String[] args) {
		
		File file = new File("list_countries1.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Countries countries = (Countries) unmarshaller.unmarshal(file);
			
			System.out.println(countries);
		} catch (JAXBException e) {			
			e.printStackTrace();
		}
				
	}

}
