package com.virtusa.springbootdemo.productapp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name = "Product_Table")
public class Product {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productImage;
	private Integer productQuantity;
	private double productPrice;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany
	private List<Cart> cart;
	
	@OneToMany
	private List<Orders> orders;
	public Product() { 
	}
	public Product(Integer productId, String productName, String productImage, Integer productQuantity,
			double productPrice, Category category, List<Cart> cart, List<Orders> orders) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.category = category;
		this.cart = cart;
		this.orders = orders;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", category=" + category
				+ ", cart=" + cart + ", orders=" + orders + "]";
	}

}