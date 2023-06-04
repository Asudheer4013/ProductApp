package com.virtusa.springbootdemo.productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.springbootdemo.productapp.dto.ProductResponse;
import com.virtusa.springbootdemo.productapp.dto.Response;
import com.virtusa.springbootdemo.productapp.entity.Category;
import com.virtusa.springbootdemo.productapp.entity.Customer;
import com.virtusa.springbootdemo.productapp.entity.Product;
import com.virtusa.springbootdemo.productapp.repository.CartRepository;
import com.virtusa.springbootdemo.productapp.service.CategoryService;
import com.virtusa.springbootdemo.productapp.service.CustomerService;
import com.virtusa.springbootdemo.productapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CategoryService categoryService;
	

	@RequestMapping("addproduct") 
	public ModelAndView addproduct() {
		List<Category> category = categoryService.getCategories();
		System.out.println(category);
		ModelAndView mv = new ModelAndView("add_product_form");
		 mv.addObject("categories", category);
		 new Product();
		 return mv;
	}
	
	@RequestMapping("productdetails") 
	public ModelAndView productdetails() {
		ModelAndView mv = new ModelAndView("details");

		 return mv;
	}
	

	
	@RequestMapping("allproducts")
	public ModelAndView allproducts() {
		List<Product> product = productService.getProducts();
		System.out.println(product);
		List<Category> category = categoryService.getCategories();
		ModelAndView mv = new ModelAndView("afterloginlanding");
		mv.addObject("products", product);
		mv.addObject("categories", category);
		return mv;
	}
	
	@RequestMapping("shop")
	public ModelAndView menClothing(@RequestParam int catId) {
		System.out.println(catId);
		Category category = categoryService.getById(catId);
		List<Category> category1 = categoryService.getCategories();
		List<ProductResponse> productResponselist = productService.getAllByCategory(category.getCatid());
		List<Product> product = productService.getProducts();
		ModelAndView mv = new ModelAndView("shoppingcategories");
		mv.addObject("mens", productResponselist);
		mv.addObject("categories", category1);
		mv.addObject("products", product);
		return mv;
	}

	@RequestMapping("afterloginlanding")
	public ModelAndView productListPage(HttpServletRequest request,Model m) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		System.out.println(email);
		Customer customer= customerService.findByEmail(email);
		Integer num=customer.getCustomerid();
		List<Product> product = productService.getProducts();
		System.out.println(product);
		List<Category> category = categoryService.getCategories();
		List<Response> cart=cartRepository.getJoinInformation(num);
		ModelAndView mv = new ModelAndView("afterloginlanding");
		mv.addObject("products", product);
		mv.addObject("categories", category);
		mv.addObject("cart", cart);
		new Product();
		return mv; 
	}
	

	@RequestMapping("/productSave")
	public ModelAndView save(@ModelAttribute Product product,@RequestParam("category") int Id,Model model) {
		System.out.println(product);
		ModelAndView modelView=null;
		String msg=productService.checkProduct(product,Id);
		List<Category> category = categoryService.getCategories();
		if(msg=="product already exist")
		{
			System.out.println(msg);
			model.addAttribute("message", msg);
			model.addAttribute("categories", category);
			 modelView = new ModelAndView("add_product_form");
		}
		else 
		{
			model.addAttribute("msg", msg);
			 modelView = new ModelAndView("redirect:/afteradminlogin");
		}
		return modelView;
	}

	
	@RequestMapping("/updateProductSave")
	public ModelAndView updateProductSave(@ModelAttribute Product product,@RequestParam("category") int Id,Model model) {
		ModelAndView modelView=null;
		String message=null;
		boolean msg=productService.checkUpdateProduct(product);
		System.out.println(msg);
		if(msg==false)
		{
			 message="product already exist";
			System.out.println(message);
			model.addAttribute("message", message);
			List<Category> category = categoryService.getCategories();
			model.addAttribute("categories", category);
			 modelView = new ModelAndView("UpdateProductDetails");
		}
		else 
		{
			model.addAttribute("message", message);
			modelView = new ModelAndView("redirect:/afteradminlogin");
		}
		return modelView;
	
	}

	@RequestMapping(path = "/delete")
	public ModelAndView delete(@RequestParam("productId") int Id) {
		System.out.println(Id);
		Product product = productService.getProductById(Id);
		productService.delete(product);
		ModelAndView modelView = new ModelAndView("redirect:/afteradminlogin");
		return modelView;
	}
	
	@RequestMapping("/update")
	public ModelAndView showupdateform(@RequestParam("productId") int Id,Model model) {
		System.out.println(Id);
		List<Category> category = categoryService.getCategories();
		Product product = productService.getProductById(Id);
		System.out.println(product);
		model.addAttribute("categories", category);
		ModelAndView mv = new ModelAndView("UpdateProductDetails");
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping("/indexpage")
	public String addCours() {
		return "index";
	}

}