package com.qph.common.test;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.qph.common.InterfaceType;
import com.qph.dao.IDao;
import com.qph.model.UserDetails;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		Logger logger = Logger.getLogger(InterfaceType.REST_USERDETAILS_INTERFACE.getLogicalName());
		logger.info("Rest Userdetails log");
		//App app = (App) applicationContext.getBean("app");
		UserDetails user = null;
		
	}
	
}
