package com.test.rest.webservices;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("EmployeeFilter")
public class Employee {

	private String name;
	private String age;
	private String address;
	private String ph;

	public Employee(String name, String age, String address, String ph) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.ph = ph;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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
		return String.format("Employee [name=%s, age=%s, address=%s, ph=%s]", name, age, address, ph);
	}

}
