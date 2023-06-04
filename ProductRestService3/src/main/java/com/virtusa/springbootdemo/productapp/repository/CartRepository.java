package com.virtusa.springbootdemo.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.springbootdemo.productapp.dto.Response;
import com.virtusa.springbootdemo.productapp.entity.Cart;
import com.virtusa.springbootdemo.productapp.entity.Orders;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	@Query("SELECT new com.virtusa.springbootdemo.productapp.dto.Response(p.productId,p.productName,p.productImage,p.productPrice,c.cartid,c.quantity) FROM Cart c JOIN c.product p where c.customer.customerid=:id")
	public List<Response> getJoinInformation(Integer id);
	
	@Modifying
	@Transactional
	@Query(value="delete from cart where customer_id=? and cartid=?", nativeQuery = true)
	public void deleteCartProduct(int customerid, Integer cartid);
	
	@Query(value="SELECT * from cart where customer_id=?", nativeQuery = true)
	List<Cart> findAllByUser(Integer customerid);
	
	
//	@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d INNER JOIN d.employees e")
//	List<DeptEmpDto> fetchEmpDeptDataInnerJoin();
	
	
	
//	@Query("SELECT new com.roytuts.spring.data.jpa.left.right.inner.cross.join.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d LEFT JOIN d.employees e")
//	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();
} 