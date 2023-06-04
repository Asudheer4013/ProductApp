package com.virtusa.springbootdemo.productapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartid=1000;

	private int quantity=1;
	private double price;

	//(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	




	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer cartid, int quantity, Product product) {
		super();
		this.cartid = cartid;
		this.quantity = quantity;
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public int getQuantity() {
		return quantity;
	} 

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", quantity=" + quantity + ", product=" + product + "]";
	}

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="customer_id")
//	private Customer customer;

}