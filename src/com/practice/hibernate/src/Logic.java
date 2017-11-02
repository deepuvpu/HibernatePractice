package com.practice.hibernate.src;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Logic {
	public static void main(String[] args) {

		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
//		cfg.configure("com/practice/hibernate/config/hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();
		configuration.configure("com/practice/hibernate/config/hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setId(111);
		e1.setFirstName("deepu");
		e1.setLastName("reddy");
		session.persist(e1);
		t.commit();
		session.close();
		System.out.println("successful");

	}

}
