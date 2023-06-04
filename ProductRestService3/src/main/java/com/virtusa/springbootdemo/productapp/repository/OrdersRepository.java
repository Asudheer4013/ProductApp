package com.virtusa.springbootdemo.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.springbootdemo.productapp.dto.Response;
import com.virtusa.springbootdemo.productapp.entity.Orders;







@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

	List<Response> save(List<Response> cart);

	@Query(value="SELECT * from orders where customer_id=?", nativeQuery = true)
	List<Orders> findAllByUser(Integer customerid);
	
	
	



	
}
