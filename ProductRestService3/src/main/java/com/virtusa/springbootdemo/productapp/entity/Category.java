package com.virtusa.springbootdemo.productapp.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table
@Data
public class Category {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer catid;
	private String categoryName;
	@OneToMany (mappedBy = "category" ,cascade = CascadeType.ALL)
	private List<Product> product;
	
	public Category() {
}

public Category(Integer catid, String categoryName) {
	super();
	this.catid = catid;
	this.categoryName = categoryName;
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

@Override
public String toString() {
	return "Category [catid=" + catid + ", categoryName=" + categoryName + "]";
}
}