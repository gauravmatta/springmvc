package com.springimplant.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springimplant.mvc.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate; 
	
	public int saveUser(User user) {
		return (Integer)this.hibernateTemplate.save(user);
	}

}
