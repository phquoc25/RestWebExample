package com.qph.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="DISTRICT_NAME")
	private String district;
	@Column(name="CITY_NAME")
	private String city;
	
	public Address() {
	}
	
	public Address(String street, String district, String city) {
		this.street = street;
		this.district = district;
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String cty) {
		this.city = cty;
	}
	
}
