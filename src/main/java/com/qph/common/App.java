package com.qph.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qph.model.UserDetails;
import com.qph.userdetails.bo.UserDetailsBo;

public class App {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		applicationContext.registerShutdownHook();
		UserDetailsBo userDetailsBo = (UserDetailsBo) applicationContext.getBean("userDetailsBo");
		
		UserDetails user = (UserDetails) applicationContext.getBean("userDetails");
		user.showAddress();
		//userDetailsBo.save(user);
		
		
	}
}
