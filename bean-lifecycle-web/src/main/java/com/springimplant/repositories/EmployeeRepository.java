package com.springimplant.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springimplant.entity.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public void save(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> findAll(){
		String jpql = "Select c from Employee c";
		TypedQuery<Employee> query =	entityManager.createQuery(jpql,Employee.class);
		return query.getResultList();
	}
	
	public Employee findById(Integer id) {
		return entityManager.find(Employee.class, id);
	}
	
	@Transactional
	public Employee update(Employee employee) {
		return entityManager.merge(employee);
	}
	
	@Transactional
	public void delete(Integer id) {
		Employee contact = entityManager.find(Employee.class,id);
		entityManager.remove(contact);
	}

}
