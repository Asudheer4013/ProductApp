package com.virtusa.springbootdemo.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.springbootdemo.productapp.dto.Response;
import com.virtusa.springbootdemo.productapp.entity.Orders;
import com.virtusa.springbootdemo.productapp.repository.OrdersRepository;



@Service
public class OrderService {
	@Autowired
	private OrdersRepository ordersRepository;



	public List<Response> saveall(List<Response> cart) {
		// TODO Auto-generated method stub
		return ordersRepository.save(cart);
	}



	public void saveorder(List<Orders> orderlist) {
		// TODO Auto-generated method stub
	//	ordersRepository.save(order);
		ordersRepository.saveAll(orderlist);
		
	}



	public void saveorder(Orders order) {
		// TODO Auto-generated method stub
		ordersRepository.save(order);
	}



	public List<Orders> findall() {
		// TODO Auto-generated method stub
		
		return ordersRepository.findAll();
	}



	public List<Orders> findAllByUser(int customerid) {
		return ordersRepository.findAllByUser(customerid);
	}

	
}
