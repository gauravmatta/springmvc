package com.springimplant.connectionpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.connectionpooling.documents.Client;
import com.springimplant.connectionpooling.repository.ClientRepository;

@SpringBootApplication
@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@PostMapping("/saveclient")
	public int saveClient(@RequestBody List<Client> clients) {
		repository.saveAll(clients);
		return clients.size();
	}
	
	@GetMapping("/findAll")
	public Iterable<Client> findAllCustomers(){
		return repository.findAll();
	}
	
	@GetMapping("/findByFName/{firstName}")
	public List<Client> findByFirstName(@PathVariable String firstName){
		return repository.findByFirstName(firstName);
	}
}
