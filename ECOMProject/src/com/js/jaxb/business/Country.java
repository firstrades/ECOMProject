package com.js.jaxb.business;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.js.jaxb.adapter.DateAdapter;

@XmlType(propOrder = {"name", "capital", "foundation", "continent", "population"})
@XmlRootElement(name = "Country")
public class Country {

	int       population;
	String    name;
	String    capital;
	String    continent;
	LocalDate foundation;
	
	
	
	public int getPopulation() {
		return population;
	}
	public String getName() {
		return name;
	}
	public String getCapital() {
		return capital;
	}
	public String getContinent() {
		return continent;
	}
	public LocalDate getFoundation() {
		return foundation;
	}
	
	
	
	@XmlElement(name = "Country_Population")
	public void setPopulation(int population) {
		this.population = population;
	}
	@XmlElement(name = "Country_Name")
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name = "Country_Capital")
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@XmlElement(name = "Country_Continent")
	public void setContinent(String continent) {
		this.continent = continent;
	}
	@XmlElement(name = "Country_Foundation_Date")
	@XmlJavaTypeAdapter(DateAdapter.class)
	public void setFoundation(LocalDate foundation) {
		this.foundation = foundation;
	}
	
	
	@Override
	public String toString() {
		
		StringBuffer str = new StringBuffer("Name: " + getName() + "\n");
		str.append("Capital: " + getCapital() + "\n");
		
		if (getFoundation() != null) {
			
			str.append(getFoundation().toString());
			str.append("\n");
		}
		
		if (getContinent() != null) {
			
			str.append(getContinent().toString());
			str.append("\n");
		}
		
		return str.toString();
	}
	
	
	
	
	
	
}
