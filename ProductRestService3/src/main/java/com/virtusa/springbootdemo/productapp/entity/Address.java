package com.virtusa.springbootdemo.productapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {
	@Id
	private Integer addressId;
	private String address;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Orders> orders;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer addressId, String address, List<Orders> orders) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.orders = orders;
	}
	public Address(int addressId, String address) {
		this.addressId = addressId;
		this.address = address;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", orders=" + orders + "]";
	}
	

}
