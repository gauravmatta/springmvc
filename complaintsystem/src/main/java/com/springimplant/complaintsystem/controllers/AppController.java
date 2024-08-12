package com.springimplant.complaintsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/fileComplaint")
	public String fileComplaint() {
		return "fileComplaint";
	}
	
	@RequestMapping("/submitComplaint")
	public String submitComplaint() {
		return "submitComplaint";
	}
	
	@GetMapping(name="/showComplaints")
	public String showComplaints() {
		return "showEnterPassword";
	}
	
	@PostMapping(name="/showComplaints")
	public String showComplaintsPost() {
		return "showComplaints";
	}

}