package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.dto.CategoryUpdateDto;
import com.ty.entities.Category;
import com.ty.repositories.CategoryRepository;
import com.ty.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	 @Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public ResponseEntity<?> createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable int id,@RequestBody CategoryUpdateDto categoryUpdateDto) {
		return categoryService.updateCategoryById(id,categoryUpdateDto);
	}
};
