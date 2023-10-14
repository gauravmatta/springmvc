package com.springimplant.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

	@RequestMapping(value = "/contact")
	public String showForm() {
		return "contact";
	}
	
	@RequestMapping(value= "/processform",method = RequestMethod.POST)
	public String handleForm(HttpServletRequest request,@RequestParam("email") String userEmail,@RequestParam("username") String userName,@RequestParam("password") String UserPassword,Model model) {
		String reqemail = request.getParameter("email");
		System.out.println("User Email is "+ reqemail);
		System.out.println("User Email is "+ userEmail);
		String requsername = request.getParameter("username");
		System.out.println("User UserName is "+ requsername);
		System.out.println("User Username is "+ userName);
		String reqpassword = request.getParameter("password");
		System.out.println("User Password is "+ reqpassword);
		System.out.println("User Password is "+ UserPassword);
		model.addAttribute("useremail", userEmail);
		model.addAttribute("username", userName);
		model.addAttribute("userPassword", UserPassword);
		return "success";
	}
}
