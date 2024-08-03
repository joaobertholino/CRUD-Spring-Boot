package dev.joaobertholino.apiresttest.services.exceptions;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException() {
	}

	public OrderNotFoundException(String message) {
		super(message);
	}
}
