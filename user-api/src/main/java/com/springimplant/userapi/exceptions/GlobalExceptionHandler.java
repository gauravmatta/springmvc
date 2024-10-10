package com.springimplant.userapi.exceptions;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.springimplant.userapi.contracts.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourseNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = ApiResponse.builder()
		.message(message)
		.success(true)
		.status(HttpStatus.NOT_FOUND)
		.build();
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerUsernameNotFoundException(UsernameNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = ApiResponse.builder()
		.message(message)
		.success(true)
		.status(HttpStatus.NOT_FOUND)
		.build();
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ApiResponse> handlerNoResourceFoundException(NoResourceFoundException ex){
		log.info(ex.toString());
		String message = ex.getMessage();
		ApiResponse apiResponse = ApiResponse.builder()
		.message(message)
		.success(true)
		.status(HttpStatus.NOT_FOUND)
		.build();
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
