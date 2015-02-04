package com.qph.resources;

import javax.ws.rs.core.Response;

import com.qph.model.UserDetails;

public interface UserDetailsServices {
	public Response save(UserDetails userDetails);
	public Response update(UserDetails userDetails);
	public Response delete(UserDetails userDetails);
	public UserDetails findById(String userName);
}
