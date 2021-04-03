package com.example.model;

import java.io.Serializable;
import javax.persistence.*;

import javax.validation.constraints.NotBlank;


@Entity
public class CarModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer carID;
	@NotBlank
	private String carModel;//
	@NotBlank
	private String adminID;
	@NotBlank
	private String status;
	
	@NotBlank
	private String price;//
	@NotBlank
	private String type;//
	
	public Integer getCarID() {
		return carID;
	}
	public void setCarID(Integer carID) {
		this.carID = carID;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
//	public CarModel(@NotBlank String carModel, @NotBlank String price, @NotBlank String type) {
//		this.carModel = carModel;
//		this.price = price;
//		this.type = type;
//		this.status = "available";
//	}
	public CarModel() {
	}
	public CarModel(Integer carID, @NotBlank String carModel, @NotBlank String adminID, @NotBlank String status,
			@NotBlank String price, @NotBlank String type) {
		super();
		this.carID = carID;
		this.carModel = carModel;
		this.adminID = adminID;
		this.status = status;
		this.price = price;
		this.type = type;
	}
	
}
