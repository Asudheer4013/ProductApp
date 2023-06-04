package com.virtusa.springbootdemo.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.virtusa.springbootdemo.productapp.entity.Customer;
import com.virtusa.springbootdemo.productapp.repository.CustomerRepository;

@Service
@Component
public class CustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	
	
	
	public String saveUser(Customer customer) {
		Customer Exsistngcustomer=customerRepository.findByEmail(customer.getEmail());
		if(Exsistngcustomer == null) {
			customerRepository.save(customer);
			return "user details saved";
		}
		else
		{
			return "user already exist";
		}
		
	}




	public Customer FindByNameAndPassword(String name,String password ) {
		return customerRepository.getByNameAndPassword(name,password);
		
	}

	public List<Customer> findAll() {
		
		return customerRepository.findAll();
	}


	public Customer findByName(String name) {
		
		return customerRepository.getByName(name);
	}




	public Customer FindByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		 return customerRepository.getByEmailAndPassword(email,password);
	}




	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}
	
	


}
