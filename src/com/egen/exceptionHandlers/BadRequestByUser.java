package com.egen.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad Requset By user")
public class BadRequestByUser extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
