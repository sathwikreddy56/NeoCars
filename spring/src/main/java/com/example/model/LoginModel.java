package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;

@Entity
public class LoginModel {
	@NotBlank
	@Size(max = 50)
	@Email
	@Id
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	public LoginModel(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password) {
		this.email = email;
		this.password = password;
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
}
