package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

	
	
	Product findByName(String name);
	List<Product> findByPrice(double price);
	Product findByNameAndPrice(String name,double price);
	
	
	// Here I combining two tables
	//Fetch product imformation based on category name
	//JPQL queries -class name or variable name---platform independent
	// * not working in JPQL Everything use by alias name here
	
	@Query("SELECT p from Product p INNER JOIN p.category c where c.name=:categoryName")
	List<Product> fetchProductByCategoryName(String categoryName);
	
	List<Product> findByCategoryName(String name);
	
	//select * from product where name='' -platform dependent
	@Query(value="select * from Product where name=:name", nativeQuery=true)
	List<Product> findByProductUsingNativeQuery(String name);
	
	// List<Product> findByCategoryNameAndCategoryId(String name,Long id);
	
}
