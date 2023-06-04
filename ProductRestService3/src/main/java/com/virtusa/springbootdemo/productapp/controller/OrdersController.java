package com.virtusa.springbootdemo.productapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.springbootdemo.productapp.entity.Address;
import com.virtusa.springbootdemo.productapp.entity.Cart;
import com.virtusa.springbootdemo.productapp.entity.Customer;
import com.virtusa.springbootdemo.productapp.entity.Orders;
import com.virtusa.springbootdemo.productapp.entity.Product;
import com.virtusa.springbootdemo.productapp.repository.CartRepository;
import com.virtusa.springbootdemo.productapp.repository.OrdersRepository;
import com.virtusa.springbootdemo.productapp.repository.ProductRepository;
import com.virtusa.springbootdemo.productapp.service.CartService;
import com.virtusa.springbootdemo.productapp.service.CustomerService;
import com.virtusa.springbootdemo.productapp.service.OrderService;
import com.virtusa.springbootdemo.productapp.service.ProductService;



@Controller
public class OrdersController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("order") 
	public ModelAndView order(@RequestParam("id") int id,HttpServletRequest request,Model m) {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		System.out.println(id);
		System.out.println(email);
		Customer customer= customerService.findByEmail(email);
		Address address=new Address();
		address.setAddressId(567);
		Orders order=new Orders();
		order.setAddress(address);
		order.setCustomer(customer);
		Cart cart=cartService.getProductById(id); //actually it is cart id.
		order.setProduct(cart.getProduct());
		order.setTotalPrice(cart.getPrice());
		order.setQuantity((int) cart.getQuantity());
		order.setCart(cart);
		orderService.saveorder(order);
		Product product = productService.getProductById(order.getProduct().getProductId());
		int quan=product.getProductQuantity()-cart.getQuantity();
		product.setProductQuantity(quan);
		productRepository.save(product);
		ModelAndView modelView = new ModelAndView("redirect:/orders");
		return modelView;
		
	}

	@RequestMapping("directorder") 
	public ModelAndView directorder(@RequestParam("id") int id,HttpServletRequest request,Model m) {
	
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		System.out.println(email);
		Customer customer= customerService.findByEmail(email);
		Address address=new Address();
		address.setAddressId(567);
		Orders order=new Orders();
		order.setAddress(address);
		order.setCustomer(customer);
		Product product1 = productService.getProductById(id);
		order.setProduct(product1);
		order.setTotalPrice(product1.getProductPrice());
		order.setQuantity(1);
		Cart cart=cartService.getProductById(id);
		order.setCart(cart);
		orderService.saveorder(order);
		Product product = productService.getProductById(order.getProduct().getProductId());
		System.out.println(product);
		System.out.println(order.getProduct().getProductId());
		System.out.println(product.getProductQuantity());
		int quan=product.getProductQuantity()-cart.getQuantity();
		product.setProductQuantity(quan);
		System.out.println(order.getQuantity());
		System.out.println(product.getProductId());
		productRepository.save(product);
		ModelAndView modelView = new ModelAndView("redirect:/orders");
		return modelView;
		
	}
	
//	@RequestMapping("orders")
//	public ModelAndView cartpage(Model m) {
//		ModelAndView mv = null;
////		try {
//			List<Orders> orderslist=orderService.findall();
//			List<Cart> cart = cartRepository.findAll();
//
//			System.out.println(cart);
//			System.out.println(orderslist);
//			mv = new ModelAndView("orderspage");
//			m.addAttribute("orderslist", orderslist);
//			mv.addObject("cart", cart);
//			double total = 0;
//			for (Orders p : orderslist) {
//				total = total + p.getTotalPrice() * p.getQuantity();
//				for(Cart c:cart)
//				{
//					if(c.getProduct().getProductId()==p.getProduct().getProductId())
//					{
//						cartRepository.delete(c);
//						int count=c.getQuantity();
//						System.out.println(count);
//						p.getQuantity();
//					}
//				}
//			}
//	
//			m.addAttribute("total", total);
////		} catch (Exception e) {
////			mv = new ModelAndView("index");
////		}
//		return mv;
//	}
	
	@RequestMapping("checkout")
	public ModelAndView checkout(Model m,HttpSession session) {
		ModelAndView mv = null;
		try {

			 String email = (String) session.getAttribute("user");
			 System.out.println(email);
			 Customer customer= customerService.findByEmail(email);
				Address address=new Address();
				address.setAddressId(567);
		List<Cart> cartlist=cartService.findAllByUser(customer.getCustomerid());
		List<Orders> orderlist=new ArrayList<Orders>();
		Orders order=new Orders();
		for(Cart i:cartlist)
		{
			orderlist.add(new Orders(i.getQuantity(),i.getPrice(),address,i,i.getCustomer(),i.getProduct()));
	
		}
		ordersRepository.saveAll(orderlist);
		for(Cart i:cartlist)
		{
			Product product = productService.getProductById(i.getProduct().getProductId());
			int quan=product.getProductQuantity()-i.getQuantity();
			product.setProductQuantity(quan);
			productRepository.save(product);
		}
		 mv = new ModelAndView("redirect:/orders");
		} catch (Exception e) {
			mv = new ModelAndView("index");
		}
		return mv;
	}
	
	@RequestMapping("orders")
	public ModelAndView cartPage(Model m,HttpSession session) {
		ModelAndView mv = null;
		try {

			 String email = (String) session.getAttribute("user");
			 System.out.println(email);
			 Customer customer= customerService.findByEmail(email);
				System.out.println("In orders");
				System.out.println(customer.getCustomerid());
			List<Orders> ordersList=orderService.findAllByUser(customer.getCustomerid());
			System.out.println("In orders");
			System.out.println(ordersList);

			List<Cart> cart = cartRepository.findAll();
			System.out.println(cart);

			mv = new ModelAndView("orderspage");
			mv.addObject("ordersList", ordersList);
			mv.addObject("cart", cart);
			double total = 0;
			for (Orders p : ordersList) {
				total =total+ p.getTotalPrice();
				System.out.println(total);
				for(Cart c:cart)
				{
					if(c.getCartid()==p.getCart().getCartid())
					{
						cartRepository.deleteCartProduct(customer.getCustomerid(),c.getCartid());
						
					}
				}
				
			}
	
			m.addAttribute("total", total);

		} catch (Exception e) {
			mv = new ModelAndView("index");
		}
		return mv;
	}

}
