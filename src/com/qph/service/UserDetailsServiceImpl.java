package com.qph.service;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.qph.model.UserDetails;
import com.qph.repository.IRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements IService<UserDetails>, InitializingBean, DisposableBean{
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private IRepository<UserDetails> userDetailsDao;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void save(UserDetails userDetails) {
		userDetailsDao.save(userDetails);
	}
	
	public IRepository<UserDetails> getUserDetailsDao() {
		return userDetailsDao;
	}

	public void setUserDetailsDao(IRepository<UserDetails> userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}

	public void update(UserDetails userDetails) {
		userDetailsDao.update(userDetails);
	}

	public void delete(UserDetails userDetails) {
		userDetailsDao.delete(userDetails);
	}

	public UserDetails findById(int userId) {
		return userDetailsDao.findById(userId);
	}

	@Override
	public List<UserDetails> getAll() {
		return userDetailsDao.getAll();
	}
	
	public void userDetailsBoInit(){
		System.out.println("userDetailsBoInit get called.");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("UserDetailsServiceImpl afterPropertiesSet get called.");
		
	}

	public void destroy() throws Exception {
		System.out.println("UserDetailsServiceImpl destroy get called.");
		System.out.println("UserDetailsServiceImpl " + this.messageSource.getMessage("greeting", null, "Default message", null));
	}

}
