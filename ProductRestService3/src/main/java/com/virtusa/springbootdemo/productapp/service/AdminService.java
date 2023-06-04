package com.virtusa.springbootdemo.productapp.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.springbootdemo.productapp.entity.Admin;
import com.virtusa.springbootdemo.productapp.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public String saveadmin(Admin admin) {
		Admin exsistngAdmin=adminRepository.getByEmail(admin.getEmail());
		if(exsistngAdmin == null) {
			adminRepository.save(admin);
			return "admin details saved";
		}
		else
		{
			return "admin already exist";
		}	
	}

	public Admin FindByEmailAndPassword(String email, String password) {
		return adminRepository.getByEmailAndPassword(email,password);
	}

	
	public void logout(HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		HttpSession session = request.getSession();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String uid = (String) session.getAttribute("user");
		System.out.println(uid);
		if (uid == null) 
		{
			response.sendRedirect("index");
		}
	}
}
