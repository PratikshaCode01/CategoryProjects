package com.ty.responsestructure;

	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class ResponseStructure<T> {

		private Integer statusCode;

		private String message;

		private T data;
	}

