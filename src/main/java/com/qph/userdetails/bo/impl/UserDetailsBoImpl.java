package com.qph.userdetails.bo.impl;

import com.qph.dao.UserDetailsDao;
import com.qph.model.UserDetails;
import com.qph.userdetails.bo.UserDetailsBo;

public class UserDetailsBoImpl implements UserDetailsBo{
	
	private UserDetailsDao userDetailsDao;
	
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

}
