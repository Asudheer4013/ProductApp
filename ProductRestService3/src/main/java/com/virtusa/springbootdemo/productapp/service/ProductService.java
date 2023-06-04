package com.virtusa.springbootdemo.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.virtusa.springbootdemo.productapp.entity.Category;
import com.virtusa.springbootdemo.productapp.entity.Product;
import com.virtusa.springbootdemo.productapp.repository.ProductRepository;

@Service
@Component
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public void delete(Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);
	}

	public List<com.virtusa.springbootdemo.productapp.dto.ProductResponse> getAllByCategory(Integer catid) {
		// TODO Auto-generated method stub
		return productRepository.getAllByCategory(catid);
	}

	public String checkProduct(Product product, int Id) {
		Product exsistngProduct = productRepository.getByProductName(product.getProductName());
		System.out.println(exsistngProduct);
		if (exsistngProduct == null) {
			Category category = categoryService.getById(Id);
			product.setCategory(category);
			addProduct(product);
			productRepository.save(product);
			return "product details saved";
		} else {
			return "product already exist";
		}
	}

	public boolean checkUpdateProduct(Product product) {
		int c = 1;
		List<Product> productlist = productRepository.exceptOriginal(product.getProductId());
		System.out.println(productlist);
		for(Product i:productlist)
		{
			if(product.getProductName().equals(i.getProductName()))
			{
				c++;
//				System.out.println("inside if,going to duplicate");
			}
		}
		if(c==1)
		{
			productRepository.save(product);
			return true;
		}
		else
		{
			return false;
		}

	}


}
