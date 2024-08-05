package dev.joaobertholino.apiresttest.exceptions;

import dev.joaobertholino.apiresttest.services.exceptions.OrderNotFoundException;
import dev.joaobertholino.apiresttest.services.exceptions.ProductNotFoundException;
import dev.joaobertholino.apiresttest.services.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException exception, HttpServletRequest servletRequest) {
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String error = "Invalid ID value";
		StandardError standardError = new StandardError(timestamp, status.value(), error, exception.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<StandardError> userNotFoundException(UserNotFoundException exception, HttpServletRequest servletRequest) {
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "User not found";
		StandardError standardError = new StandardError(timestamp, status.value(), error, exception.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<StandardError> orderNotFoundException(OrderNotFoundException exception, HttpServletRequest servletRequest) {
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Order not found";
		StandardError standardError = new StandardError(timestamp, status.value(), error, exception.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<StandardError> productNotFoundException(ProductNotFoundException exception, HttpServletRequest servletRequest) {
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Product not found";
		StandardError standardError = new StandardError(timestamp, status.value(), error, exception.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<StandardError> transactionSystemException(TransactionSystemException exception, HttpServletRequest servletRequest) {
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String error = "JPA transactional error";
		StandardError standardError = new StandardError(timestamp, status.value(), error, exception.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<StandardError> noResourceFoundException(NoResourceFoundException exception, HttpServletRequest servletRequest) {
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Resource not found";
		StandardError standardError = new StandardError(timestamp, status.value(), error, exception.getMessage(), servletRequest.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
}
