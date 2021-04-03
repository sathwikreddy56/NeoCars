package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class AdminModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminID;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String mobileNumber;
	@NotBlank
	private String sellerName;
	@NotBlank
	private String userRole;
	@NotBlank
	private String companyName;
	@NotBlank
	private String companyImageURL;
	@NotBlank
	private String companyAddress;
	@NotBlank
	private Integer earnings;
	public String getEmail() {
		return email;
	}
	public Integer getAdminID() {
		return adminID;
	}
	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyImageURL() {
		return companyImageURL;
	}
	public void setCompanyImageURL(String companyImageURL) {
		this.companyImageURL = companyImageURL;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public Integer getEarnings() {
		return earnings;
	}
	public void setEarnings(Integer earnings) {
		this.earnings = earnings;
	}
	public AdminModel() {
		super();
	}
	public AdminModel(@NotBlank @Email String email, @NotBlank String password, @NotBlank String mobileNumber,
			@NotBlank String sellerName, @NotBlank String userRole, @NotBlank String companyName,
			@NotBlank String companyImageURL, @NotBlank String companyAddress, @NotBlank Integer earnings) {
		super();
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.sellerName = sellerName;
		this.userRole = userRole;
		
		this.companyName = companyName;
		this.companyImageURL = companyImageURL;
		this.companyAddress = companyAddress;
		this.earnings = earnings;
	}
	
	
	
	
}
