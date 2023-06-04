package com.virtusa.springbootdemo.productapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.springbootdemo.productapp.entity.Category;
import com.virtusa.springbootdemo.productapp.entity.Customer;
import com.virtusa.springbootdemo.productapp.service.CategoryService;
import com.virtusa.springbootdemo.productapp.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("register")
	public String register()
	{
		return "register";
	}

	@RequestMapping("login")
	public String login()
	{
		return "login";
	}

	@RequestMapping("loginlandinghome")
	public ModelAndView loginlandinghome(Model m)
	{
		List<Category> category = categoryService.getCategories();
		ModelAndView modelView = new ModelAndView("loginlandinghome");
		m.addAttribute("categories", category);
		return modelView;
	}

	@RequestMapping(value = "/validatelogin", method = RequestMethod.POST)
	public String loginvalidation(@AuthenticationPrincipal Customer customer, HttpServletRequest request,
			HttpServletResponse response,Model m) throws IOException
	{
		try
		{
			String email = request.getParameter("email");
			Customer customer1 = customerService.FindByEmailAndPassword(customer.getEmail(), customer.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("user", email);                      // THIS IS HOW WE DECLARE THE USER IN A SESSION
			// String uid = (String) session.getAttribute("user");
			if (customer.getEmail().equals(customer1.getEmail())
					&& customer.getPassword().equals(customer1.getPassword()))
			{
				return "redirect:/afterloginlanding";
			}
		}
		catch (Exception e)
		{
			m.addAttribute("message", "Invalid credentials/user doesn't exist");
			return "login";
		}
		return null;
	}

	@RequestMapping("/")
	public String index()
	{
		return "index";
	}

	@RequestMapping("index")
	public String indexMainhome()
	{
		return "index";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}

	@RequestMapping("saveuser")
	public String home(@ModelAttribute Customer customer, ModelMap model)
	{
		String msg = customerService.saveUser(customer);
		if (msg == "user already exist")
		{
			System.out.println(msg);
			model.addAttribute("msg", msg);
			return "register";
		} else
		{
			return "login";
		}

	}

}
