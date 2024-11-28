package com.ty.exception;

public class CategoryNotFound extends RuntimeException {

	private String message;

	public CategoryNotFound() {
	}

	public CategoryNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
