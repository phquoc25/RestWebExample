package com.qph.common.test;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import org.hibernate.usertype.UserVersionType;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qph.common.comparators.UserDetailsByNameComparator;
import com.qph.model.UserDetails;
import com.qph.service.IService;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		applicationContext.registerShutdownHook();
		IService userDetailsService = (IService) applicationContext.getBean("userDetailsBo");
		
		UserDetails user = (UserDetails) applicationContext.getBean("userDetails");
		user.setUserName("Quoc");
		
		UserDetails user1 = (UserDetails) applicationContext.getBean("userDetails");
		user1.setUserName("Chieu");
		
		UserDetails user2 = (UserDetails) applicationContext.getBean("userDetails");
		user2.setUserName("Phong");
		
		Vector<UserDetails> usersVector = new Vector<UserDetails>();
		usersVector.add(user);
		usersVector.add(user1);
		usersVector.add(user2);
		
		Enumeration<UserDetails> elements = usersVector.elements();
		while(elements.hasMoreElements()){
			System.out.println(elements.nextElement());
		}
		
		Collections.sort(usersVector, new UserDetailsByNameComparator());
		
		Iterator<UserDetails> iterator = usersVector.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		//userDetailsBo.save(user);
	}
	
}
