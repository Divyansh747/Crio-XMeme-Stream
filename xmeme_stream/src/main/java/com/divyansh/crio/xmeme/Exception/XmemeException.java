package com.divyansh.crio.xmeme.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception class of HttpStatus type CONFLICT ERROR 409
@ResponseStatus(HttpStatus.CONFLICT)
public class XmemeException extends RuntimeException {

	/**
	 * 
	 * @param message - accept message from exception
	 */

	public XmemeException(String error) {
		super(error);
	}

	/**
	 * 
	 * @param message - accept message from exception
	 * @param cause - Throwable cause for exception
	 */
	public XmemeException(String error, Throwable cause) {
		super(error, cause);
	}
}
