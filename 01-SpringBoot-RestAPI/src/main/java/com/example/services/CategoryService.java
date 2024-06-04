package com.example.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Category;
import com.example.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/*
	 * public void categoryName(Category categoryname) {
	 * log.info("categoryrepository :: categoryName {}", categoryname.getName());
	 * categoryRepository.save(categoryname);
	 * log.info("Category saved successfully in DB"); }
	 * 
	 * public List<Category> fetchAllCategory(){
	 * log.info("categoryRepository::fetchAllCategory"); return
	 * categoryRepository.findAll(); }
	 * 
	 * public Category findByCategoryId(Long categoryId) {
	 * log.info("categoryRepository::findByCategoryId {}",categoryId); return
	 * categoryRepository.findById(categoryId).orElseThrow(()->new
	 * EntityNotFoundException("category not found By id")); }
	 * 
	 * public Category updateById(Long categoryId,Category cate) { return
	 * categoryRepository.findById(categoryId).map(obj->{
	 * obj.setName(cate.getName()); return categoryRepository.save(obj);
	 * }).orElseThrow(()->new EntityNotFoundException("Category Name not found"));
	 * 
	 * }
	 * 
	 * public void deleteCategoryById(Long categoryId) {
	 * if(categoryRepository.existsById(categoryId)) {
	 * categoryRepository.deleteById(categoryId); }else { throw new
	 * EntityNotFoundException("categoryId not found"); } }
	 */

	
	public void createCategory(Category category) {
		categoryRepository.save(category);
	}
	
	
	
	
	}
	


