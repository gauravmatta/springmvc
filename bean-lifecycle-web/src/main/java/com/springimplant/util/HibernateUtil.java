package com.springimplant.util;

import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springimplant.entity.Employee;

public class HibernateUtil {
	@PersistenceUnit(name = "HypersistenceOptimizer")
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration cfg = new Configuration();
        	cfg.configure("hibernate.cfg.xml");
        	return cfg.addAnnotatedClass(Employee.class)
            		.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
