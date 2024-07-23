package org.activiti.designer.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootTest
public class ProcessTestProcesspool1 {

	private String filename = "/home/gaurav/projects/springmvc/activiti-demo/src/main/resources/processes/ServiceProcess.bpmn";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		System.out.println("Repository has Started");
		repositoryService.createDeployment().addInputStream("process_pool1.bpmn20.xml",
				new FileInputStream(filename)).deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		variableMap.put("abc", 5);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process_pool1", variableMap);
		System.out.println("Proces is Deployed");
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
		System.out.println("Service Task Execution Completed");
	}
}