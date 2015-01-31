package com.qph.userdetails.bo;

import com.qph.model.UserDetails;

public interface UserDetailsBo {
	
	public void save(UserDetails userDetails);
	public void update(UserDetails userDetails);
	public void delete(UserDetails userDetails);
	public UserDetails findById(String userName);
	
}
