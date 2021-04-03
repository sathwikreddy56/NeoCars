package com.example.Utils;

public class allcompanies {
	private String companyName;
	private String companyImageURL;
	private String companyAddress;
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
	public allcompanies(String companyName, String companyImageURL, String companyAddress) {
		this.companyName = companyName;
		this.companyImageURL = companyImageURL;
		this.companyAddress = companyAddress;
	}
	public allcompanies() {

	}
	
	
}
