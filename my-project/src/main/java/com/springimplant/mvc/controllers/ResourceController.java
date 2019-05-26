package com.springimplant.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springimplant.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model)
	{
		List<String> options=new LinkedList<>(Arrays.asList(new String[]{"Material","Other","Staff","Technical Equipment"}));
		List<String> radios=new LinkedList<>(Arrays.asList(new String[]{"Hours","Piece","Tons"}));
		List<String> checks=new LinkedList<>(Arrays.asList(new String[]{"Lead Time","Special Rate","Requires Approval"}));
		model.addAttribute("itemOptions",options);
		model.addAttribute("radioOptions",radios);
		model.addAttribute("checkOptions",checks);
		model.addAttribute("resource",new Resource());
		return "resource_add";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource,Model model) throws ClassNotFoundException
	{
		List<String> options=new LinkedList<>(Arrays.asList(new String[]{"Material","Other","Staff","Technical Equipment"}));
		List<String> radios=new LinkedList<>(Arrays.asList(new String[]{"Hours","Piece","Tons"}));
		List<String> checks=new LinkedList<>(Arrays.asList(new String[]{"Lead Time","Special Rate","Requires Approval"}));
		model.addAttribute("itemOptions",options);
		System.out.println("Invoking save() method");
		System.out.println(resource);
		//Class.forName("com.mysql.jdbc.driver");
		//Connection con=DriverManage.getConnection("jdbcmysql:///Db1","root","2338");
		//Statement st=
		model.addAttribute("resource",resource);
		model.addAttribute("radioOptions",radios);
		model.addAttribute("checkOptions",checks);
		return "resource_add";
	}
}
