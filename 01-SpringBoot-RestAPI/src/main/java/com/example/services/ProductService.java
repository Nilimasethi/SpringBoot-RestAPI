package com.example.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.models.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	public void createProduct(Product product) {
		product.setInStock(true);
		product.setBarcode(UUID.randomUUID().toString());
		productRepository.save(product);
		
	}
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(
			()-> new ResourceNotFoundException("Product Not Found"));
	}
	public List<Product> fetchProduct(String name) {
		// TODO Auto-generated method stub
		return productRepository.fetchProductByCategoryName(name);
	}
	
	public List<Product> findByCategoryName(String name){
		return productRepository.findByCategoryName(name);
	}
}
