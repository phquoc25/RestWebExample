package com.qph.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qph.model.UserDetails;
import com.qph.userdetails.bo.UserDetailsBo;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		UserDetailsBo userDetailsBo = (UserDetailsBo) applicationContext.getBean("userDetailsBo");
		
		UserDetails user = new UserDetails();
		user.setUserName("Quoc PHAN");
		userDetailsBo.save(user);
		
	}
}
