package com.ty.exception;

public class InvalidException  extends RuntimeException{


		private String message;

		public InvalidException() {
		}

		public InvalidException(String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return this.message;
		}
}
