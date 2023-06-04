package com.virtusa.springbootdemo.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.springbootdemo.productapp.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer getByNameAndPassword(String name, String password);
	public Customer getByName(String name);
	public Customer getByEmailAndPassword(String email, String password);
	public Customer findByEmail(String email);
	
}