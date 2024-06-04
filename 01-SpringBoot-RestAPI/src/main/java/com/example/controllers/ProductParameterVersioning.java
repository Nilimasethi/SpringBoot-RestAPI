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
@RequestMapping("api/product/parameter")
public class ProductParameterVersioning {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	//In Swagger this API not working so i try on this -http://localhost:8080/api/product/parameter?version=2
	//This is another way to versioning with parameter
	//public List<Product> fetch(@RequestParam (defaultValue=1,required=false)String version)
	
	@GetMapping(params="version=1")
	public List<Product> fetch(){
		return productRepository.findAll();
	}
	
	@GetMapping(params="version=2")
	public List<Product> fetchProductInDescendingOrder(){
		return productRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Product::getPrice).reversed())
				.toList();
	}
}
