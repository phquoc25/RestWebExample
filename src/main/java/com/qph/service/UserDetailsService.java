package com.qph.service;

import com.qph.model.UserDetails;

public interface UserDetailsService {
	
	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);
	public void delete(UserDetails userDetails);
	public UserDetails findById(String userName);
	
}
