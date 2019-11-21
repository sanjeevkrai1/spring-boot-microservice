package com.test.rest.webservices.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private int id;

	@Size(min = 20, message = "Name should be atleast two characters")
	private String name;
	
	private int age;
	
	@Past
	private Date birthDate;

	public User(int id, String name, int age, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [name=%s, age=%s, birthDate=%s]", name, age, birthDate);
	}

}
