package com.virtusa.springbootdemo.productapp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderid;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	private Double totalPrice;
	@ManyToOne
	@JoinColumn(name = "AddressId")
	private Address address;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartid")
	private Cart cart;
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer orderid, Product product, Customer customer, Double totalPrice, Address address) {
		super();
		this.orderid = orderid;
		this.product = product;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.address = address;
	}

	public Orders(int quantity2, double price, Address address2, Cart i, Customer customer2, Product product2) {
		this.quantity = quantity2;
		this.totalPrice = price;
		this.address = address2;
		this.cart = i;
		this.customer = customer2;
		this.product = product2;
		// TODO Auto-generated constructor stub
	}

	// public Cart getCart() {
//		return cart;
//	}
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", product=" + product + ", customer=" + customer + ", totalPrice="
				+ totalPrice + ", address=" + address + "]";
	}

}
