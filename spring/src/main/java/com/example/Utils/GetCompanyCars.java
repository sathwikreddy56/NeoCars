package com.example.Utils;

public class GetCompanyCars {
	private String companyName;
	private String adminID;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public GetCompanyCars(String companyName, String adminID) {
		super();
		this.companyName = companyName;
		this.adminID = adminID;
	}
	
}
