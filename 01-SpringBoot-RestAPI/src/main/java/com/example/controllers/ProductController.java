package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.repository.ProductRepository;
import com.example.services.ProductService;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@PostMapping                               //@RequestHeader String UserId
    public void createProduct(@RequestBody Product product) {
	productService.createProduct(product);
	
	}
	@GetMapping("{productId}") 
	public Product fetchProduct(@PathVariable Long productId) {
		return productService.getProductById(productId);
		
	}
	
	@GetMapping("/fetch")
	public List<Product> fetch(){
		return productRepository.findAll();
	}
	
	
	@GetMapping("category/{name}")
	public List<Product> fetchProductByCategoryName(@PathVariable String name){
		return productService.fetchProduct(name);
	}

}
