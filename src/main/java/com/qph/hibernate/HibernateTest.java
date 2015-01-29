package com.qph.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.qph.dto.UserDetails;
import com.qph.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 10); 
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 10);
		session2.getTransaction().commit();
		session2.close();
		
	}

}
