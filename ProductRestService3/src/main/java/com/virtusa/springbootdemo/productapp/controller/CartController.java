package com.virtusa.springbootdemo.productapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.springbootdemo.productapp.dto.Response;
import com.virtusa.springbootdemo.productapp.entity.Cart;
import com.virtusa.springbootdemo.productapp.entity.Customer;
import com.virtusa.springbootdemo.productapp.entity.Product;
import com.virtusa.springbootdemo.productapp.repository.CartRepository;
import com.virtusa.springbootdemo.productapp.service.CartService;
import com.virtusa.springbootdemo.productapp.service.CustomerService;
import com.virtusa.springbootdemo.productapp.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartRepository cartRepository;
	
	public  List<Response>totallist = new ArrayList<Response>();

	@RequestMapping("shoppingpage") 
	public ModelAndView register(HttpServletRequest request,Model m) {
		ModelAndView mv =null;
		try
		{
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		System.out.println(email);
		Customer customer= customerService.findByEmail(email);
		Integer num=customer.getCustomerid();
		List<Response> cart=cartRepository.getJoinInformation(num);
		System.out.println(cart);
		cart.forEach(l -> System.out.println(l));
		List<Product> product = productService.getProducts();
		//System.out.println(product);
		 mv = new ModelAndView("shopping");
		String msg="added";
		System.out.println(msg);
		m.addAttribute("msg", msg);
		mv.addObject("products", product);
		}
		catch(Exception e) {
			 mv = new ModelAndView("index");
			
		}
		return mv;
	}
	@RequestMapping("cartpage") 
	public ModelAndView cartpage(HttpServletRequest request,Model m) {
		ModelAndView mv=null;
		try
		{
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		System.out.println(email);
		Customer customer= customerService.findByEmail(email);
		Integer num=customer.getCustomerid();
		List<Response> cart=cartRepository.getJoinInformation(num);
		System.out.println(cart);
		cart.forEach(l -> System.out.println(l));
		 mv = new ModelAndView("cartpage");
		mv.addObject("cartproducts", cart);
			double total = 0;
			for(Response p:cart)
			{
				 total=total+p.getProductPrice() * p.getQuantity();
			}
			m.addAttribute("total", total);
	
		}
		catch(Exception e)
		{
			 mv = new ModelAndView("index");
		}
		return mv;
	}
	Customer customer;
	@RequestMapping(path="/addtocart") 
	public ModelAndView addtocart(Cart cart,@RequestParam("id") int Id,Model model,HttpServletRequest request,HttpServletResponse response,Model m) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		System.out.println(email);
		ModelAndView modelView = null;
		if(email!=null)
		{
		Customer customer= customerService.findByEmail(email);
		Product product = productService.getProductById(Id);
		cart.setProduct(product);
		cart.setCustomer(customer);
		cart.setPrice(product.getProductPrice());
		cartService.addCart(cart);
		String msg="added";
		System.out.println(msg);
		m.addAttribute("msg", msg);
		 modelView = new ModelAndView("redirect:/afterloginlanding");
	}
		else
		{
			 modelView = new ModelAndView("redirect:/index");
		}
		return modelView;
		
	}
	
	@RequestMapping(path = "/cartdelete")
	public ModelAndView delete(@RequestParam("productId") int Id) {
		System.out.println(Id);
		Cart cart = cartService.getProductById(Id);
		System.out.println(cart);
		cartService.delete(cart);
		ModelAndView modelView = new ModelAndView("redirect:/cartpage");
		return modelView;
	}
	
	@RequestMapping(path = "/incre")
	public ModelAndView increment(@RequestParam("id")  int id) {
		System.out.println(id);

		Cart cart = cartService.getProductById(id);
		System.out.println(cart.getQuantity());
		int quantity = cart.getQuantity();
		
		if (quantity >= 1) {
			++quantity; 
			cart.setQuantity(quantity);
			cart.setPrice(cart.getPrice()*quantity);
			cartService.addCart(cart);
		}

		ModelAndView modelView = new ModelAndView("redirect:/cartpage");
		return modelView;
	}

	@RequestMapping(path = "/decre")
	public ModelAndView decrement(@RequestParam("id")  int id) {
		System.out.println(id);

		Cart cart = cartService.getProductById(id);
		int quantity = cart.getQuantity();
		if (quantity > 1) {
			--quantity; 
			cart.setQuantity(quantity);
			cart.setPrice(cart.getPrice()*quantity);
			cartService.addCart(cart);
		}
		ModelAndView modelView = new ModelAndView("redirect:/cartpage");
		return modelView;
	}


}
