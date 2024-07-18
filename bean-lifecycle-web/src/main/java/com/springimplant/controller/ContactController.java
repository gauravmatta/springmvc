package com.springimplant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.dto.ContactDto;
import com.springimplant.entity.Contact;
import com.springimplant.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveContact(@RequestBody ContactDto contact){
		contactService.createContact(contact);
		return ResponseEntity.ok("Success");
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateContact(@RequestBody ContactDto contact){
		contactService.updateContact(contact);
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getContactList(){
	List<Contact> contacts =	contactService.listContacts();
	return ResponseEntity.ok(contacts.toString());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getContactByid(@PathVariable Integer id){
	Contact contact =	contactService.getContact(id);
	return ResponseEntity.ok(contact.toString());
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<?> deleteContactByid(@PathVariable Integer id){
	contactService.deleteContact(id);
	return ResponseEntity.ok("Success");
	}
	
}
