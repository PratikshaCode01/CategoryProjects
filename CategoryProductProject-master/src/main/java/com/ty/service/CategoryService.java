package com.ty.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.dto.CategoryDto;
import com.ty.dto.CategoryUpdateDto;
import com.ty.entities.Category;
import com.ty.exception.CategoryNotFound;
import com.ty.repositories.CategoryRepository;
import com.ty.responsestructure.ResponseStructure;

@Service
public class CategoryService {
@Autowired
 private CategoryRepository categoryRepository;

public ResponseEntity<?>createCategory(Category category) {
	Optional<Category> opt=categoryRepository.findByName(category.getName());
	if (opt.isPresent()) {
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Already present");
		rs.setData(category.getName());
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}else {
		Category save=categoryRepository.save(category);
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setMessage("Category created");
		rs.setData(category.getName());
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
	
}

public ResponseEntity<?> getCategoryById(int id) {
	Category category = categoryRepository.findById(id)
			.orElseThrow(() -> new CategoryNotFound("Category does not exist"));

	CategoryDto dto = new CategoryDto();

	BeanUtils.copyProperties(category, dto);

	ResponseStructure<CategoryDto> rs = new ResponseStructure<>();
	rs.setStatusCode(HttpStatus.OK.value());
	rs.setMessage("Fetched Successfully");
	rs.setData(dto);
	return new ResponseEntity<ResponseStructure<CategoryDto>>(rs, HttpStatus.OK);
}

public ResponseEntity<?> updateCategoryById(int id,CategoryUpdateDto categoryUpdateDto) {
	
	Category category=categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFound("Category does not exist"));
	if(categoryUpdateDto.getName()!=null) {
		category.setName(categoryUpdateDto.getName());
	}
	if(categoryUpdateDto.getDescription()!=null) {
		category.setDescription(categoryUpdateDto.getDescription());
	}
	Category save=categoryRepository.save(category);
	
	CategoryUpdateDto dto = new CategoryUpdateDto();

	BeanUtils.copyProperties(category, dto);
	
	ResponseStructure<CategoryUpdateDto> rs = new ResponseStructure<>();
	rs.setStatusCode(HttpStatus.OK.value());
	rs.setMessage("Status Updated Successfully");
	rs.setData(dto);
	return new ResponseEntity<ResponseStructure<CategoryUpdateDto>>(rs, HttpStatus.OK);
}

public Page<Category> getAllCategories(int page,int size){
	return categoryRepository.findAll(PageRequest.of(page, size));
}

}








	

