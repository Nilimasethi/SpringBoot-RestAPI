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
@RequestMapping("api/product")
public class ProductHeaderVersioning {
	//Header Versioning to handleing version
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping(headers="X-API-VERSION=1")
	public List<Product> fetch(){
		return productRepository.findAll();
	}
	
	@GetMapping(headers="X-API-VERSION=2")
	public List<Product> fetchProductInDescendingOrder(){
		return productRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Product::getPrice).reversed())
				.toList();
	}

}
