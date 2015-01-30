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

import com.qph.entity.FourWheeler;
import com.qph.entity.TwoWheeler;
import com.qph.entity.UserDetails;
import com.qph.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			FourWheeler fourWheeler = (FourWheeler) applicationContext.getBean("fourwheeler");
			fourWheeler.setName("Bike 2");
			fourWheeler.setSteeringWheel("steeringWheel of four wheeler");

			UserDetails user = (UserDetails)applicationContext.getBean("userdetails");
			user.setUserName("Chieu Luu");
			user.setDescription("Secirity guy.");
			user.getVehicles().add(fourWheeler);
			
			session.save(user);
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
