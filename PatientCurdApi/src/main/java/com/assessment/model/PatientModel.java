package com.assessment.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class PatientModel {

        @Id
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String phone;
	@NotNull
	private String disease;
	@NotNull
	private String bedNo;
	@NotNull
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
