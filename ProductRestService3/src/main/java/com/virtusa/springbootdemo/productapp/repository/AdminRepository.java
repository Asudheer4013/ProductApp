package com.virtusa.springbootdemo.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.springbootdemo.productapp.entity.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
	public Admin getByEmail(String email);
	public Admin getByEmailAndPassword(String email ,String password);
}
