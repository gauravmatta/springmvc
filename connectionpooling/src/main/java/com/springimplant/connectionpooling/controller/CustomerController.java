package com.springimplant.connectionpooling.controller;

import java.util.List;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.batch.core.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.connectionpooling.entity.Customers;
import com.springimplant.connectionpooling.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@Autowired
	@Qualifier("partitionedjob")
	private Job partitionedJob;
	
	@GetMapping("/getcustomers")
	public ResponseEntity<List<Customers>> getcustomer(){
		List<Customers> customers =	cService.processCustomers();
		return ResponseEntity
		        .status(HttpStatus.OK)
		        .header("Custom-Header", "Custom-Value")
		        .body(customers);
	}
	
	@PostMapping("/load")
	public void importCsvToDBJob() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("startAt",System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping("/loadpartition")
	public void importCsvToDBJobUsingPartition() {
		JobParameters jobParameters = new JobParametersBuilder().addLong("startAt",System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(partitionedJob, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

}
