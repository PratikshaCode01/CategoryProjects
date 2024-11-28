package com.ty.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{
 
	Optional<Category> findByName(String name);

	
	
	
}
