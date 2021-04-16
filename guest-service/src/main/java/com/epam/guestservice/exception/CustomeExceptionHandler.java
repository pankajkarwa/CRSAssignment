package com.epam.guestservice.exception;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleEAllException(Exception ex, WebRequest request) {
		//System.out.println("inside custom");
		ExceptionResponce exceptionResponce = new ExceptionResponce(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<Object>(exceptionResponce, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
		//System.out.println("inside custom");
		ExceptionResponce exceptionResponce = new ExceptionResponce(ex.getMessage(), request.getDescription(false),
				new Date());
		return new ResponseEntity<Object>(exceptionResponce, HttpStatus.NOT_FOUND);
		
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponce exceptionResponce = new ExceptionResponce("Validation Fail", 
				ex.getBindingResult().toString(),
				new Date());

		return new ResponseEntity<Object>(exceptionResponce, HttpStatus.BAD_REQUEST);
	}

}
