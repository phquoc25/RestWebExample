package com.qph.resources;

import com.qph.model.UserDetails;

public interface UserDetailsServices {
	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);
	public void delete(UserDetails userDetails);
	public UserDetails findById(String userName);
}
