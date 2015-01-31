package com.qph.dao;

import com.qph.model.UserDetails;

public interface UserDetailsDao {

	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);
	public void delete(UserDetails userDetails);
	public UserDetails findById(String userName);
}
