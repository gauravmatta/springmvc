package com.springimplant.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springimplant.entity.Contact;

@Repository
public class ContactRepository {
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save(Contact contact) {
		entityManager.persist(contact);
	}
	
	public List<Contact> findAll(){
		String jpql = "Select c from Contact c";
		TypedQuery<Contact> query =	entityManager.createQuery(jpql,Contact.class);
		return query.getResultList();
	}
	
	public Contact findById(Integer id) {
		return entityManager.find(Contact.class, id);
	}
	
	@Transactional
	public Contact update(Contact contact) {
		return entityManager.merge(contact);
	}
	
	@Transactional
	public void delete(Integer id) {
		Contact contact = entityManager.find(Contact.class,id);
		entityManager.remove(contact);
	}
	
}
