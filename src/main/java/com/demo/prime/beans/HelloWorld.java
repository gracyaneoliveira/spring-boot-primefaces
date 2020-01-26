package com.demo.prime.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class HelloWorld implements Serializable{

	private static final long serialVersionUID = 1L;

	private String firstName = "John";
	private String lastName = "Doe";

	@PostConstruct
	public void init() {
		System.out.println(">>> init ...");
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String showGreeting() {
		return "Hello " + firstName + " " + lastName + "!";
	}

}
