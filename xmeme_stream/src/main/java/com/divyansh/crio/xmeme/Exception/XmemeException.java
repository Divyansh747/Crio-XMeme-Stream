package com.divyansh.crio.xmeme.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class XmemeException extends RuntimeException {

	public XmemeException(String error) {
		super(error);
	}

	public XmemeException(String error, Throwable cause) {
		super(error, cause);
	}
}
