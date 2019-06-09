package com.springimplant.mvc.controllers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springimplant.mvc.annotations.ClassNameAnnotation;
import com.springimplant.mvc.annotations.StaticTextAnnotation;
import com.springimplant.mvc.entity.AnnotationChildren;
import com.springimplant.mvc.entity.AnnotationParent;

@Controller
@RequestMapping("/play")
public class PlayController {

	@RequestMapping("/annotation")
	public String annotationTest()
	{
		try {
			Method method=AnnotationParent.class.getMethod("test",new Class[]{HttpServletRequest.class});
			Annotation staticTextAnnot=AnnotationUtils.findAnnotation(method,StaticTextAnnotation.class);
			System.out.println("@StaticTextAnnotation of method is: "+staticTextAnnot);
		    System.out.println("@StaticTextAnnotation method value: "+AnnotationUtils.getValue(staticTextAnnot, "text"));
		    System.out.println("@StaticTextAnnotation method default value: "+AnnotationUtils.getDefaultValue(staticTextAnnot, "text"));
		    System.out.println("@StaticTextAnnotation value: "+AnnotationUtils.getValue(staticTextAnnot));
		    
	    	// inheriting annotations tests
		    Annotation classNameAnnotation = AnnotationUtils.findAnnotation(AnnotationChildren.class, ClassNameAnnotation.class);
		    System.out.println("@ClassNameAnnotation of TestChildren.class is: "+classNameAnnotation);
		    System.out.println("@ClassNameAnnotation method value: "+AnnotationUtils.getValue(classNameAnnotation, "className"));
		    System.out.println("@ClassNameAnnotation method default value: "+AnnotationUtils.getDefaultValue(classNameAnnotation, "className"));
		    System.out.println("@ClassNameAnnotation value: "+AnnotationUtils.getValue(classNameAnnotation));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "annotation";
	}
}
