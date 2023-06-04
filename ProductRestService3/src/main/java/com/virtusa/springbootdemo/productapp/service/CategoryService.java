package com.virtusa.springbootdemo.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.springbootdemo.productapp.entity.Category;
import com.virtusa.springbootdemo.productapp.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	public Category getById(int id) {
		return categoryRepository.getById(id);
	}

	public Category findBycategoryName(String name) {
		return categoryRepository.getBycategoryName(name);
	}

	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	public void updateCategory(Category category) {
		categoryRepository.save(category);

	}

	public String checkCategory(Category category) {
		Category exsistngProduct =findBycategoryName(category.getCategoryName());
		System.out.println(exsistngProduct);
		if (exsistngProduct == null) {
			saveCategory(category);
			categoryRepository.save(category);
			return "category details saved";
		} else {
			return "category already exist";
		}
	}

	public boolean checkUpdateCategory(Category category) {
		int c = 1;
		List<Category> categorylist = categoryRepository.exceptOriginal(category.getCatid());
		System.out.println(categorylist);
		for(Category i:categorylist)
		{
			if(category.getCategoryName().equals(i.getCategoryName()))
			{
				c++;
//				System.out.println("inside if,going to duplicate");
			}
		}
		if(c==1)
		{
			categoryRepository.save(category);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	

}
