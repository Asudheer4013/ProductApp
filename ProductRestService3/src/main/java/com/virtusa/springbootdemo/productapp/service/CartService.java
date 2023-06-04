package com.virtusa.springbootdemo.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.virtusa.springbootdemo.productapp.entity.Cart;
import com.virtusa.springbootdemo.productapp.repository.CartRepository;

@Service
@Component
public class CartService {

	@Autowired
	CartRepository cartRepository;
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub 
		return cartRepository.save(cart);
	}
	public Cart getProductById(int id) {
		// TODO Auto-generated method stub
		return cartRepository.getById(id);
	}
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.delete(cart);
	}
	public List<Cart> findAllByUser(int customerid) {
		// TODO Auto-generated method stub
		return cartRepository.findAllByUser(customerid);
	}
	
	

}
