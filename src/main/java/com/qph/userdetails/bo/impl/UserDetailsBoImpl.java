package com.qph.userdetails.bo.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.qph.dao.UserDetailsDao;
import com.qph.model.UserDetails;
import com.qph.userdetails.bo.UserDetailsBo;

@Service("userDetailsBo")
public class UserDetailsBoImpl implements UserDetailsBo, InitializingBean, DisposableBean{
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UserDetailsDao userDetailsDao;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void save(UserDetails userDetails) {
		userDetailsDao.save(userDetails);
	}

	public UserDetailsDao getUserDetailsDao() {
		return userDetailsDao;
	}

	public void setUserDetailsDao(UserDetailsDao userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}

	public void update(UserDetails userDetails) {
		userDetailsDao.update(userDetails);
	}

	public void delete(UserDetails userDetails) {
		userDetailsDao.delete(userDetails);
	}

	public UserDetails findById(String userName) {
		return userDetailsDao.findById(userName);
	}
	
	public void userDetailsBoInit(){
		System.out.println("userDetailsBoInit get called.");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("UserDetailsBoImpl afterPropertiesSet get called.");
		
	}

	public void destroy() throws Exception {
		System.out.println("UserDetailsBoImpl destroy get called.");
		System.out.println("UserDetailsBoImpl " + this.messageSource.getMessage("greeting", null, "Default message", null));
	}
}
