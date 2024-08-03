package dev.joaobertholino.apiresttest.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public record StandardError(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss:SS'Z'", timezone = "GMT") LocalDateTime timestamp,
														Integer status,
														String error,
														String message,
														String path) implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
}
