package com.ty.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
