package com.qph.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qph.model.UserDetails;
import com.qph.util.CustomHibernateDaoSupport;

@Repository("userDetailsDao")
public class UserDetailsHibernateDao extends CustomHibernateDaoSupport
		implements IDao<UserDetails> {

	@Override
	public void save(UserDetails t) {
		getHibernateTemplate().save(t);
		
	}

	@Override
	public void update(UserDetails t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public void delete(UserDetails t) {
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public UserDetails findById(int userId) {
		List users = getHibernateTemplate().find(
				"from UserDetails where userId=?", userId);
		if(!users.isEmpty()){
			return (UserDetails) users.get(0);
		}
		return null;
	}

	@Override
	public List<UserDetails> getAll() {
		return getHibernateTemplate().find("from UserDetails");
	}

}
