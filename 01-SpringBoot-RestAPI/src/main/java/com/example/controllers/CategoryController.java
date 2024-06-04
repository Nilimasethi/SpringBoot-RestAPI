package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Category;

import com.example.services.CategoryService;



@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	@Autowired 
	private CategoryService categoryService;
	
	/*
	 * 
	 * 
	 * @PostMapping public void creatCategoryName(@RequestBody Category
	 * categoryname) { categoryService.categoryName(categoryname); }
	 * 
	 * @GetMapping("{categoryId}") public Category getCategoryById(@PathVariable
	 * Long categoryId ) { return categoryService.findByCategoryId(categoryId); }
	 * 
	 * @PutMapping("{categoryId}") public Category updateCategoryById(@PathVariable
	 * Long categoryId,@RequestBody Category cate) { return
	 * categoryService.updateById(categoryId,cate); }
	 * 
	 * @DeleteMapping("{categoryId}") public void deleteCategoryById(@PathVariable
	 * Long categoryId) { categoryService.deleteCategoryById(categoryId); }
	 */
	
	@PostMapping
public void createCategory(@RequestBody Category category) {
	categoryService.createCategory(category);
}
}
