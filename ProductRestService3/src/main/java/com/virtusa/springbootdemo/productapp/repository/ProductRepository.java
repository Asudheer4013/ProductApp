package com.virtusa.springbootdemo.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.virtusa.springbootdemo.productapp.dto.ProductResponse;
import com.virtusa.springbootdemo.productapp.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	//List<Product> getAllByCategory( Integer i);

	@Query("SELECT new com.virtusa.springbootdemo.productapp.dto.ProductResponse(p.productId,p.productName,p.productImage,p.productPrice,p.category.categoryName,c.catid) FROM Product p JOIN p.category c where p.category.catid=:id")
	public List<ProductResponse> getAllByCategory(Integer id);

	public Product getByProductName(String productName);
	
	@Query(value="select * from product_table where product_id!=?", nativeQuery = true)
	public List<Product> exceptOriginal(Integer id);
	
//	
//	@Query("SELECT new com.virtusa.springbootdemo.productapp.dto.Response(p.productId,p.productName,p.productImage,p.productPrice,c.cartid) FROM Cart c JOIN c.product p where c.customer.customerid=:id")
//	public List<Response> getJoinInformation(Integer id);
//	

}