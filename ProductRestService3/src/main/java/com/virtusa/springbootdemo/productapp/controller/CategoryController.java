package com.virtusa.springbootdemo.productapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.virtusa.springbootdemo.productapp.entity.Category;
import com.virtusa.springbootdemo.productapp.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/displayCategories")
	public ModelAndView displayCategories() {
		List<Category> categories = categoryService.getCategories();
		System.out.println(categories);
		ModelAndView mv = new ModelAndView("Categories");
		mv.addObject("categories", categories);
		return mv;
	}

	@RequestMapping("/addcategory")
	public String addCategory() {
		return "category";
	}

	@RequestMapping("/savecategory")
	public ModelAndView saveCategory(@ModelAttribute Category category,Model model) {
		ModelAndView modelView=null;
		String msg=categoryService.checkCategory(category);
		if(msg=="category already exist")
		{
			System.out.println(msg);
			model.addAttribute("message", msg);
			 modelView = new ModelAndView("category");
		}
		else 
		{
			model.addAttribute("msg", msg);
			modelView = new ModelAndView("redirect:/displayCategories");
		}
		return modelView;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id) {
		Category category = categoryService.getById(id);
		categoryService.delete(category);
		ModelAndView mv = new ModelAndView("redirect:/displayCategories");
		return mv;
	}

	@RequestMapping("/updatecategory")
	public String updateCategory(@RequestParam("id") int id, Model m) {
		Category category = categoryService.getById(id);
		m.addAttribute("category", category);
		return "updatecategory";
	}
	
	
	@RequestMapping("/updatecategorysave")
	public ModelAndView updateCategorySave(@ModelAttribute Category category,Model model) {
		ModelAndView modelView=null;
		String message=null;
		boolean msg=categoryService.checkUpdateCategory(category);
		System.out.println(msg);
		if(msg!=true)
		{
			 message="category already exist";
			System.out.println(message);
			model.addAttribute("message", message);
			 modelView = new ModelAndView("updatecategory");
		}
		else 
		{
			model.addAttribute("message", message);
			modelView = new ModelAndView("redirect:/displayCategories");
		}
		return modelView;
	
	}

}
