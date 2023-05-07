package com.greenfoarfece.smb.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 8462640722835116224L;
	
	private Long personId;
	private String firstName;
	private String lastName;
	private String occupation;
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
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
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", occupation="
				+ occupation + "]";
	}
	
}
