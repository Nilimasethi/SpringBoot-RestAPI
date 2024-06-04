package com.example.controllers;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.repository.ProductRepository;
import com.example.services.ProductService;

@RestController
//this is URL versioning
@RequestMapping("api/v2/product")
public class ProductV2Controller {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	
	@GetMapping("/fetch")
	public List<Product> fetch(){
		return productRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Product::getPrice).reversed())
				.toList();
	}
	
	
	

}
