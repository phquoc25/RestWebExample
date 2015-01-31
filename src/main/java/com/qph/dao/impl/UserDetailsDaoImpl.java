package com.qph.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.qph.dao.UserDetailsDao;
import com.qph.model.UserDetails;

public class UserDetailsDaoImpl extends HibernateDaoSupport implements UserDetailsDao {

	public void save(UserDetails userDetails) {
		getHibernateTemplate().save(userDetails);
	}

	public void update(UserDetails userDetails) {
		getHibernateTemplate().update(userDetails);
	}

	public void delete(UserDetails userDetails) {
		getHibernateTemplate().delete(userDetails);
	}

	public UserDetails findById(String userId) {
		List users = getHibernateTemplate().find("from UserDetails where userId=?", userId);
		return (UserDetails) users.get(0);
	}

}
