package com.CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.entity.Product;
import com.CRUD.repository.ProductRepositoty;

@Service
public class ProductService {
	@Autowired
	ProductRepositoty repositoty; // ProductService talk to Repository that is why we need to inject it
	
	//Write all the methods for get,post,delete and put
	
	//POST methods
	public Product saveProduct(Product product)
	{
		return repositoty.save(product);
	}
	public List<Product> saveProducts(List<Product> products)
	{
		return repositoty.saveAll(products);
	}
	
	//GET
	public List<Product> getProducts()
	{
		return repositoty.findAll();
	}

	public Product getProductById(int id)
	{
		return repositoty.findById(id).orElse(null); //it returns optional , if it didnt get the Product the
	}
	public List<Product> getProductByName(String name)
	{
		return repositoty.findByName(name);
	}
	
	
	//DELETE
	public String deleteProduct(int id)
	{
		repositoty.deleteById(id);
		return "Product removed with id: "+id;
	}
	
	//PUT
	public Product updateProduct(Product product) // pass the product to update
	{
		//first get the existing/passed product based on its id and then modify it.
		Product existingProduct = repositoty.findById(product.getId()).orElse(null);
		//updating
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return repositoty.save(existingProduct);
	}
	
}
