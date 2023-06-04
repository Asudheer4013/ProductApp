package com.virtusa.springbootdemo.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.springbootdemo.productapp.entity.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {


	public Category getByCategoryName(String categoryName);

	public Category getBycategoryName(String name);
	
	@Query(value="select * from category where catid!=?", nativeQuery = true)
	public List<Category> exceptOriginal(Integer catid);
}
