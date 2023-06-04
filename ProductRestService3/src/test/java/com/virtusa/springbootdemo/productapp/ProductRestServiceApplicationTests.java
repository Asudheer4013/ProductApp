package com.virtusa.springbootdemo.productapp;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.virtusa.springbootdemo.productapp.entity.Customer;
import com.virtusa.springbootdemo.productapp.repository.CustomerRepository;
import com.virtusa.springbootdemo.productapp.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRestServiceApplicationTests {

@Autowired
private CustomerService customerService;

@MockBean
private CustomerRepository customerRepository;

@Test
public void getUsersTest() {
	when(customerRepository.findAll()).thenReturn(Stream.of(new Customer(12,"sudheer","askr4013@gmail.com","1234","1234567899")).collect(Collectors.toList()));
	assertEquals(1, customerService.findAll().size());
	System.out.println("hi");
}

}
