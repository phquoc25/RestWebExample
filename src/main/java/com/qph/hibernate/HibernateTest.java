package com.qph.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.qph.entity.user.UserDetails;
import com.qph.entity.vehicle.FourWheeler;
import com.qph.entity.vehicle.TwoWheeler;
import com.qph.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			TwoWheeler twoWheeler = (TwoWheeler) applicationContext.getBean("twowheeler");

			//UserDetails user = (UserDetails) session.get(UserDetails.class, 10);
			UserDetails user = (UserDetails) applicationContext.getBean("userdetails");
			user.getVehicles().add(twoWheeler);
			
			TwoWheeler twoWheeler2 = (TwoWheeler) applicationContext.getBean("twowheeler");
			UserDetails user2 = (UserDetails) applicationContext.getBean("userdetails");
			user2.getVehicles().add(twoWheeler2);
			
			session.save(user);
			session.save(user2);
			session.getTransaction().commit();
			System.out.println("Data is committed successfuly");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Session is closed.");
		}

	}
}
