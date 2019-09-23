package com.services.cart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	private int id;
	
	private String name;
	
	private String countrycode;
	
	private String district;
	
	private String population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countrycode="
				+ countrycode + ", district=" + district + ", population="
				+ population + "]";
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	}
