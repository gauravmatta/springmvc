package com.springimplant.advice;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springimplant.contract.ApiErrorContract;
import com.springimplant.exceptions.EmptyInputException;
import com.springimplant.exceptions.NoProductFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EmptyInputException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE,reason = "Pass Number Only")
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		log.info("Global Exception Called");
		return new ResponseEntity<>("Input field is empty,Please Look into it",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Null Pointer Only")
	public ResponseEntity<String> handleNullInput(EmptyInputException emptyInputException){
		return new ResponseEntity<>("Input field is Null",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NoProductFoundException.class)
	public ResponseEntity<ApiErrorContract> handleNoProductFoundException(){
		ApiErrorContract  errorContract = new ApiErrorContract(400,"No Product Found",new Date());
		return new ResponseEntity<>(errorContract,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<ApiErrorContract> handleNoSuchElementException(NoSuchElementException exception){
		ApiErrorContract  errorContract = new ApiErrorContract(400,"No Value is Present in DB, Please change your request",new Date());
		return new ResponseEntity<>(errorContract,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorContract  errorContract = new ApiErrorContract(400,"Please change your http method type",new Date());
		return new ResponseEntity<>(errorContract,HttpStatus.NOT_FOUND);
	}
}
