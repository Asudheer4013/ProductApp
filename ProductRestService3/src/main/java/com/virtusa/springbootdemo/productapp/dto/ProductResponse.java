package com.virtusa.springbootdemo.productapp.dto;

public class ProductResponse {
	
	private Integer productId;
	private String productName;
	private String productImage;
	private double productPrice;
	private String categoryName;
	private Integer catid;

	public ProductResponse() {
		super();
	}

	public ProductResponse(Integer productId, String productName, String productImage, double productPrice,
			String categoryName, Integer catid) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.categoryName = categoryName;
		this.catid = catid;
	}
	
	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public Integer getCartid() {
		return catid;
	}

	public void setCartid(Integer cartid) {
		this.catid = cartid;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductResponse [productId=" + productId + ", productName=" + productName + ", productImage="
				+ productImage + ", productPrice=" + productPrice + ", categoryName=" + categoryName + ", catid="
				+ catid + "]";
	}
}

