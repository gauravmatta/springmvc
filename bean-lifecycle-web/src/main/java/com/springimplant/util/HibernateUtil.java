package com.springimplant.util;

import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.service.ServiceRegistry;

import com.springimplant.entity.Employee;
import com.springimplant.listners.LoadEventListnerImp;
import com.springimplant.listners.UpdateEventListener;

public class HibernateUtil {
	@PersistenceUnit(name = "HypersistenceOptimizer")
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration cfg = new Configuration();
        	cfg.configure("hibernate.cfg.xml");
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();	
        	final EventListenerRegistry eventListenerRegistry =
                    serviceRegistry.getService(EventListenerRegistry.class);
        	eventListenerRegistry.appendListeners(
                    EventType.LOAD,
                    LoadEventListnerImp.INSTANCE
                );
        	 eventListenerRegistry.appendListeners(
        	            EventType.POST_UPDATE,
        	            UpdateEventListener.INSTANCE
        	        );
        	return cfg.addAnnotatedClass(Employee.class)
            		.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
