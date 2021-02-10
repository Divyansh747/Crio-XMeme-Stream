package com.divyansh.crio.xmeme.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception class of HttpStatus type NOT_FOUND ERROR 404
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 * @param message - accept message from exception
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message - accept message from exception
	 * @param cause - Throwable cause for exception
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
