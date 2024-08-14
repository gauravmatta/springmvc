package com.springimplant.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springimplant.contract.ApiErrorContract;
import com.springimplant.exceptions.EmptyInputException;
import com.springimplant.exceptions.NoProductFoundException;

@ControllerAdvice
public class MyControllerAdvice {
	@ExceptionHandler(EmptyInputException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE,reason = "Pass Number Only")
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<>("Input field is empty",HttpStatus.UNSUPPORTED_MEDIA_TYPE);
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
}
