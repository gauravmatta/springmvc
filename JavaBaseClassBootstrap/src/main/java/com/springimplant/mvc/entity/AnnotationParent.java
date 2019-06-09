package com.springimplant.mvc.entity;

import javax.servlet.http.HttpServletRequest;

import com.springimplant.mvc.annotations.ClassNameAnnotation;
import com.springimplant.mvc.annotations.StaticTextAnnotation;

@ClassNameAnnotation(className="TestChildren")
public class AnnotationParent {

	@StaticTextAnnotation(value= "Custom text value", text = "Test text")
	  public String test(HttpServletRequest request) {
	    return "test";
	  }
}
