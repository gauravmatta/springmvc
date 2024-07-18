package com.springimplant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.dto.ContactDto;
import com.springimplant.entity.Contact;
import com.springimplant.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@PostMapping("/add")
	public ResponseEntity<?> getEmpById(@RequestBody ContactDto contact){
		contactService.createContact(contact);
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getEmpList(){
	List<Contact> contacts =	contactService.listContacts();
	return ResponseEntity.ok(contacts.toString());
	}
	
}
