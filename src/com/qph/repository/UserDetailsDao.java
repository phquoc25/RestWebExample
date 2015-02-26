package com.qph.repository;

import java.util.List;

import com.qph.model.UserDetails;

public interface UserDetailsDao {

	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);
	public void delete(UserDetails userDetails);
	public UserDetails findById(int userId);
	public List getAllUsers();
}
