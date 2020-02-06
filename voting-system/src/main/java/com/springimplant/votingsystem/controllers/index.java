package com.springimplant.votingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.votingsystem.entity.Citizen;
import com.springimplant.votingsystem.repositories.CitizenRepo;

@RestController
public class index {
	
	@Autowired
	CitizenRepo citizenRepo;

	@RequestMapping("/doAction")
	public String doAction()
	{
		Citizen c1=new Citizen(1L,"Gaurav");
		citizenRepo.save(c1);
		return "Success";
	}
}
