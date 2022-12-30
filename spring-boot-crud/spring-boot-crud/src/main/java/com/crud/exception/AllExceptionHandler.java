package com.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AllExceptionHandler extends ResponseEntityExceptionHandler  {
	
	
	
	@ExceptionHandler(UsersNotFoundException.class)
	 ResponseEntity<?> response(UsersNotFoundException e)
	{
		return new ResponseEntity<>("Id not Exits",HttpStatus.NOT_FOUND);
	}

}
