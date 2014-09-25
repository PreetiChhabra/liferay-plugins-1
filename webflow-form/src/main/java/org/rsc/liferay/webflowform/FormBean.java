package org.rsc.liferay.webflowform;

import java.io.Serializable;

public class FormBean implements Serializable {

	private static final long serialVersionUID = 4317327056305789300L;

	private String lastname;

	private String firstname;

	private String email;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
