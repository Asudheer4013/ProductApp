package com.virtusa.springbootdemo.productapp.dto;

public class Response {

	private Integer productId;
	private String productName;
	private String productImage;
	private double productPrice;
	private Integer cartid;
	private int quantity;

	public Response()
	{
		super();
	}
	
	public Response(Integer productId, String productName, String productImage, double productPrice, Integer cartid,
			int quantity)
	{
		super();
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.cartid = cartid;
		this.quantity = quantity;
	}

	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public Integer getProductId()
	{
		return productId;
	}
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public Integer getCartid()
	{
		return cartid;
	}
	public void setCartid(Integer cartid)
	{
		this.cartid = cartid;
	}
	public String getProductImage()
	{
		return productImage;
	}
	public void setProductImage(String productImage)
	{
		this.productImage = productImage;
	}
	public double getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(double productPrice)
	{
		this.productPrice = productPrice;
	}
	@Override
	public String toString()
	{
		return "Response [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productPrice=" + productPrice + ", cartid=" + cartid + "]";
	}

}

