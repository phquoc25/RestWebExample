package com.qph.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qph.model.UserDetails;
import com.qph.util.CustomHibernateDaoSupport;

@Repository("userDetailsDao")
public class UserDetailsHibernateDao extends CustomHibernateDaoSupport
		implements UserDetailsDao {

	public void save(UserDetails userDetails) {
		getHibernateTemplate().save(userDetails);
	}

	public void update(UserDetails userDetails) {
		getHibernateTemplate().update(userDetails);
	}

	public void delete(UserDetails userDetails) {
		getHibernateTemplate().delete(userDetails);
	}

	public UserDetails findById(int userId) {
		List users = getHibernateTemplate().find(
				"from UserDetails where userId=?", userId);
		if(!users.isEmpty()){
			return (UserDetails) users.get(0);
		}
		return null;
	}

	public List getAllUsers() {
		return getHibernateTemplate().find("from UserDetails");
	}

}
