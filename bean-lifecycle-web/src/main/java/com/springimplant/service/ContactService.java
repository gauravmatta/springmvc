package com.springimplant.service;

import java.util.List;

import com.springimplant.dto.ContactDto;
import com.springimplant.entity.Contact;

public interface ContactService {
	public void createContact(ContactDto contact);

	List<Contact> listContacts();
	Contact getContact(Integer id);

	Contact updateContact(ContactDto contact);
}
