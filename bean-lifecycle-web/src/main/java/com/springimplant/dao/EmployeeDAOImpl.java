package com.springimplant.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springimplant.entity.Employee;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void save(Employee p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@Override
	public List<Employee> list() {
		Session session = this.sessionFactory.openSession();
		List<Employee> personList = session.createQuery("from Employee").list();
		session.close();
		return personList;
	}

}
