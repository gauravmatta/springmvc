package com.springimplant.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springimplant.dto.ContactDto;
import com.springimplant.entity.Contact;
import com.springimplant.repositories.ContactRepository;
import com.springimplant.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public void createContact(ContactDto contact) {
		mapper.disable(MapperFeature.USE_ANNOTATIONS);
		StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, contact);
			String jsonString = mapper.writeValueAsString(contact);
			Contact c  = mapper.readValue(jsonString, Contact.class);
			contactRepository.save(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Contact> listContacts() {
		return contactRepository.findAll();
	}

}
