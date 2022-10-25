package gau.springmvc.activitidemo.controllers;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@Slf4j
public class ActivitiRestController {
	
	@Autowired
	private RuntimeService runTimeService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@GetMapping(value = "/start-my-process",produces = MediaType.APPLICATION_JSON_VALUE)
	public void startMyProcess() {
		
		//Deploy the process definition
	    repositoryService.createDeployment()
	        .addClasspathResource("processes/diagram.bpmn20.xml")
	        .deploy();
        log.info("Your process should be deployed...");
		
		runTimeService.startProcessInstanceByKey("Process_0u9wu14");
		log.info("We have now "+runTimeService.createProcessInstanceQuery().count() + " process instances");
	}	
}