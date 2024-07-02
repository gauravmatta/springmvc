package com.springimplant.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.springimplant.entity.Employee;
import com.springimplant.listners.LoadEventListnerImp;
import com.springimplant.util.HibernateUtil;

@EntityScan( basePackages = {"com.springimplant.entity"} )
public class HibernateMain {
	
	static Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {
		Transaction t = session.beginTransaction();
		try {
			Employee emp = session.get(Employee.class,103);
			System.out.println("103 id :"+emp.getNames()+":"+emp.getSalary());
			emp.setSalary(15000);
			session.update(emp);
			t.commit();
			System.out.println("after 1st Commit 103 id"+emp.getNames()+":"+emp.getSalary());
			t.begin();
			session.update(emp);
			t.commit();
			Employee emp1 = session.get(Employee.class,103);
			System.out.println("after 2nd commit 103 id :"+emp1.getNames()+":"+emp1.getSalary());
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
