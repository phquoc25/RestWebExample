package com.qph.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
		    sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		} catch(Throwable ex){
			System.err.println("Initial sessionFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
