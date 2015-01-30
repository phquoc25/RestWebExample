package com.qph.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.qph.dto.TwoWheeler;
import com.qph.dto.UserDetails;
import com.qph.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource(
				"src//main//resources//spring.xml"));
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			TwoWheeler twoWheeler = (TwoWheeler) beanFactory
					.getBean("twowheeler");
			twoWheeler.setName("Bike 1");
			twoWheeler.setSteeringHandle("Handle of 2 wheels");

			UserDetails user = (UserDetails)beanFactory.getBean("userdetails");
			user.setUserName("Quoc PHAN");
			user.setDescription("Mr Phan Ho Quoc");
			user.getVehicles().add(twoWheeler);
			
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
