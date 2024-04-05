package com.springmvcimplant.ioc.config;

import org.springframework.core.convert.ConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({NullPointerException.class})
	public String NullExceptionHandler(Model m) {
		System.out.println("Centralized Null Pointer Exception Occurred");
		m.addAttribute("msg","Centralized Null Pointer Exception");
		return "null_error";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ConversionException.class,NumberFormatException.class})
	public String ConversionExceptionHandler(Model m) {
		System.out.println("Centralized Number Format Exception Occurred");
		m.addAttribute("msg","Centralized Number Format Exception");
		return "null_error";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public String GenericExceptionHandler(Model m) {
		System.out.println("Centralized General Exception Occurred");
		m.addAttribute("msg","Centralized General Exception");
		return "null_error";
	}
}
