package com.employee.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	  @ExceptionHandler(EmployeeNotFoundException.class) 
	  public ResponseEntity<String> handleENFE(EmployeeNotFoundException exception) {
	  String message = exception.getMessage(); 
	  return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST); }
	  
	 
}
