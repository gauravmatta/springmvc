package com.springimplant.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(final HttpServletRequest request,final HttpServletResponse response,final Exception ex)
	{
		// If exception has a ResponseStatus annotation then use its response code
		ResponseStatus responseStatusAnnotation = AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class);
		return buildModelAndViewErrorPage(request, response, ex,responseStatusAnnotation != null ? responseStatusAnnotation.value() : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("*")
	public ModelAndView fallbackHandler(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
			
		return buildModelAndViewErrorPage(request, response, null, HttpStatus.NOT_FOUND);
	}
	
	private ModelAndView buildModelAndViewErrorPage(final HttpServletRequest request,final HttpServletResponse response,final Exception ex,final HttpStatus httpStatus) {
		response.setStatus(httpStatus.value());
		ModelAndView mav=new ModelAndView("error");
		if(ex!=null)
		{
			mav.addObject("title",ex);
		}
		mav.addObject("content",request.getRequestURL());
		return mav;
	}

}
