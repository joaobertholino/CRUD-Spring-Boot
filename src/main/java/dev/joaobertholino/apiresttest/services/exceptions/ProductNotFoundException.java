package dev.joaobertholino.apiresttest.services.exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException() {
	}

	public ProductNotFoundException(String message) {
		super(message);
	}
}
