package com.epam.guestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class GuestNotFoundException extends RuntimeException {
	
	public GuestNotFoundException(String message){
		super(message);
		
	}

}
