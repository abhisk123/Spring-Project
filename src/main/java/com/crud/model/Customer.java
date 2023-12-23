package com.crud.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int customerId;
	@Column(name="Name")
	private String cusName;
	@Column(name="City")
	private String cusCity;
	@Column(name="State")
	private String cusState;
	@Column(name="Pincode")
	private int cusPincode;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusCity() {
		return cusCity;
	}
	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}
	public String getCusState() {
		return cusState;
	}
	public void setCusState(String cusState) {
		this.cusState = cusState;
	}
	public int getCusPincode() {
		return cusPincode;
	}
	public void setCusPincode(int cusPincode) {
		this.cusPincode = cusPincode;
	}
	
	

}
