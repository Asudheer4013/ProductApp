package com.virtusa.springbootdemo.productapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtusa.springbootdemo.productapp.entity.Admin;
import com.virtusa.springbootdemo.productapp.service.AdminService;
import com.virtusa.springbootdemo.productapp.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProductService productService;
	HttpServletResponse response;
	HttpServletRequest request;
	
	
	
	@RequestMapping("adminlogin")
	public String adminlogin() {
		return "admin";
	}
	
	@RequestMapping("adminregister")
	public String adminregister() {
		return "adminregister";
	}
	
	@RequestMapping("saveadmin")
	public String home(@ModelAttribute Admin admin,ModelMap model) {
		String msg=adminService.saveadmin(admin);
		if(msg=="admin already exist")
		{
			System.out.println(msg);
			model.addAttribute("msg", msg);
		
			return "adminregister";
		}
		else 
		{
			model.addAttribute("msg", msg);
			return "admin";
		}
		
	}
	@RequestMapping("afteradminlogin")
	public String afteradminlogin(Model model,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		adminService.logout(response,request);
	//	logout();
		model.addAttribute("products", productService.getProducts());
		return "afteradminlogin";

	} 
	
	@RequestMapping("adminlandinghome")
	public String adminlandinghome() {
		return "adminlandinghome";
	} 
	

	@RequestMapping(value = "/validateadminlogin", method = RequestMethod.POST)
	public String Adminloginvalidation( Admin admin, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try { 
			String email = request.getParameter("email");
			System.out.println("hii");
			Admin admin1 = adminService.FindByEmailAndPassword(admin.getEmail(), admin.getPassword());
			System.out.println(admin1);
			HttpSession session = request.getSession();
			session.setAttribute("user", email);// THIS IS HOW WE DECLARE THE USER IN A SESSION
			session.getAttribute("user");
			adminlandinghome();
			if (admin.getEmail().equals(admin1.getEmail())
					&& admin1.getPassword().equals(admin1.getPassword())) {
				return "redirect:/afteradminlogin";
			}
		
		} catch (Exception e) {

			return "admin";
		}
		return null; 
	}
	
	public void logout() throws IOException
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
