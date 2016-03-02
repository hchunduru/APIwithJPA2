package com.egen.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad Requset On Movie")
public class BadRequestOnMovie extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
