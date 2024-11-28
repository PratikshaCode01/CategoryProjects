package com.ty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.entities.Category;
import com.ty.entities.Product;
import com.ty.repositories.CategoryRepository;
import com.ty.repositories.ProductRepository;
import com.ty.exception.*;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Page<Product> getAllProducts(int page,int size){
		return productRepository.findAll(PageRequest.of(page, size));
		
	}

	public Product createProduct(Product product) {
		if(product.getCategory()==null || product.getCategory().getId()==null) {
			throw new InvalidException("product should have valid category");
			
		}
		Optional<Category> category=categoryRepository.findById(product.getCategory().getId());
		
		if(category.isEmpty()) {
			throw new InvalidException("Category Not found");
		}
		
		product.setCategory(category.get());
		return productRepository.save(product);
	}
	
	
}
