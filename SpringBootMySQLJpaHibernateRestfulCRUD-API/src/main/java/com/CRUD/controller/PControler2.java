package com.CRUD.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CRUD.entity.Product;
import com.CRUD.service.ProductService;

@Controller
public class PControler2 {
	@Autowired
	ProductService service;
	private int updateID;
	
	@RequestMapping("/home")
	public ModelAndView showHome()
	{
		ModelAndView mv = new ModelAndView("home");
		List<Product> products = service.getProducts();
		mv.addObject("products", products);
		return mv;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute("product") Product product)
	{
		ModelAndView mv = new ModelAndView("addProduct");
	
		return mv;
	}
	
	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product)
	{
		ModelAndView mv = new ModelAndView("addProduct");
		service.saveProduct(product);
		return mv;
	}
	
	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam("productId") int id, @ModelAttribute("product") Product product)
	{	
		updateID = id;
		ModelAndView mv = new ModelAndView("updateProduct");
		Product productToUpdate = service.getProductById(id);
		mv.addObject("product", productToUpdate);
		return mv;
	}
	
	@RequestMapping("saveUpdateProduct")
	public ModelAndView saveUpdatedProduct(@ModelAttribute("product") Product product)
	{
		product.setId(updateID);
		service.updateProduct(product);
		
		return showHome();
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int id)
	{	
		service.deleteProduct(id);
		return "redirect:/home";
	}
	
	@RequestMapping("/searchProductByName")
	public String showSearchByNamePage()
	{
		return "searchProductByName";
	}
	@RequestMapping("/searchProductByName2")
	public ModelAndView searchByName(@RequestParam("name") String  name)
	{
		List<Product> products = service.getProductByName(name);
		ModelAndView mv = new ModelAndView("home");
		if(products.isEmpty())
		{
			mv.setViewName("notFound");
		}
		mv.addObject("products", products);
		return mv;
	}
	
	@RequestMapping("/searchProductById")
	public String showSearchByIdPage()
	{
		return "searchProductById";
	}
	@RequestMapping("/searchProductById2")
	public ModelAndView searchById(@RequestParam("id") int id)
	{
		ModelAndView mv = new ModelAndView("home");
		List<Product> products = new ArrayList<Product>();
		Product product = service.getProductById(id);
		if(product == null)
		{
			mv.setViewName("notFound");
		}
		products.add(product);
		mv.addObject("products", products);
		return mv;
	}
}
