package com.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.entity.Product;
import com.CRUD.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service; // Controller talks to the service
	
	//POST
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) //@RequestBody : so the JSON input can passed to it
	{
		return service.saveProduct(product);
	}
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	
	//GET
	@GetMapping("/products")
	public List<Product> findAllProducts()
	{
		return service.getProducts();
	}
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	@GetMapping("/productByName/{name}")
	public List<Product> findProductById(@PathVariable String name)
	{
		return service.getProductByName(name);
	}

	//PUT
	@PutMapping("/update")
	public Product update(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}
	
	//DELTE
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
}
