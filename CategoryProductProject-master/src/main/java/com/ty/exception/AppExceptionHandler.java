package com.ty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.responsestructure.ResponseStructure;

@RestControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler(CategoryNotFound.class)
	public ResponseEntity<ResponseStructure<String>> catchCounsellorNotFound(CategoryNotFound message) {
	
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Category Not Found");
		rs.setData(null);

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
}
