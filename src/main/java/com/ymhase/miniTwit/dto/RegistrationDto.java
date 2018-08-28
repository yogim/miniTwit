package com.ymhase.miniTwit.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class RegistrationDto {
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	
	private String userName;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min=5, message = "Length of password should be of 5 charachter")
	private String password;
	@NotNull
	@Size(min=5, message = "Length of password should be of 5 charachter")
	private String confirmPassword;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
