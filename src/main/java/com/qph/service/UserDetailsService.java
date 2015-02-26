package com.qph.service;

import java.util.List;

import com.qph.model.UserDetails;

public interface UserDetailsService {
	
	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);
	public void delete(UserDetails userDetails);
	public UserDetails findById(String userId);
	public List getAllUsers();
	}
