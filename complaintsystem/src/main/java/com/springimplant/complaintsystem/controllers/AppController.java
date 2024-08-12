package com.springimplant.complaintsystem.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springimplant.complaintsystem.dao.ComplaintDao;
import com.springimplant.complaintsystem.entities.Complaint;

@Controller
public class AppController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping("/fileComplaint")
	public String fileComplaint() {
		Complaint p = new Complaint(4,"Hello","Gaurav","gaurav@gaurav.com");
		ComplaintDao dao= new ComplaintDao(sessionFactory);
		dao.insertComplaint(p);
		for(Complaint i : dao.getAllComplaints()) {
			System.out.println(i.getMessage());
		}
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