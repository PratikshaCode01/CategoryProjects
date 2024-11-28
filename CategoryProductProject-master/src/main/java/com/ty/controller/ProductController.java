package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entities.Category;
import com.ty.entities.Product;
import com.ty.exception.InvalidException;
import com.ty.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
  public ResponseEntity<Page<Product>>getAllProducts(@RequestParam(defaultValue="0")int page){
	  Page<Product> products=productService.getAllProducts(page, 10);
	  return ResponseEntity.ok(products);
	}
	
	
	  
	  @PostMapping("/products")
	  public ResponseEntity<Object> createProduct(@RequestBody Product product){
		  try {
			  Product products=productService.createProduct(product);
			  return new ResponseEntity<>(products,HttpStatus.CREATED);
			  
		  }catch(InvalidException e) {
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		  }
			  catch(Exception e) {
				  return (ResponseEntity<Object>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
		  
	  
	  
  }
}

