package com.test.rest.webservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"ph" , "address"})
public class User {

	private String name;
	private String address;
	private String ph;

	public User(String name, String address, String ph) {
		super();
		this.name = name;
		this.address = address;
		this.ph = ph;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	@Override
	public String toString() {
		return String.format("User [name=%s, address=%s, ph=%s]", name, address, ph);
	}

}
