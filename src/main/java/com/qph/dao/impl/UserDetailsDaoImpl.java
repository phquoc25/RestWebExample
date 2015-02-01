package com.qph.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.qph.dao.UserDetailsDao;
import com.qph.model.UserDetails;
import com.qph.util.CustomHibernateDaoSupport;

@Repository("userDetailsDao")
public class UserDetailsDaoImpl extends CustomHibernateDaoSupport implements UserDetailsDao {

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
