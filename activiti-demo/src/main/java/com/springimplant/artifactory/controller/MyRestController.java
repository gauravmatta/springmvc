package com.springimplant.artifactory.controller;



import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@GetMapping(value = "/start-my-process",produces = MediaType.APPLICATION_JSON_VALUE)
	public void startMyProcess() {
		runtimeService.startProcessInstanceByKey("testprocess");
		System.out.println("We have now "+runtimeService.createProcessInstanceQuery().count()+" process instances!");
	}
}