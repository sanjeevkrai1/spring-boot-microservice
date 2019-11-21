package com.test.rest.webservices.resource;

public class PersonV1 {

	private Name name;

	public PersonV1(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("PersonV1 [name=%s]", name);
	}

}
