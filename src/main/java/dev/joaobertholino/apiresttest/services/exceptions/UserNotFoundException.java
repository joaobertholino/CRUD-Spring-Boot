package dev.joaobertholino.apiresttest.services.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
