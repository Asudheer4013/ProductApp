package com.virtusa.springbootdemo.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ProductRestServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductRestServiceApplication.class, args);		
		   System.out.println();
	}
}        
     