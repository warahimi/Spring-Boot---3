package com.CRUD.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CRUD.entity.Product;

public interface ProductRepositoty extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);
}
