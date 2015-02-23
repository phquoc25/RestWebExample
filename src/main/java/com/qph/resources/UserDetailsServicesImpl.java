package com.qph.resources;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qph.model.UserDetails;
import com.qph.service.UserDetailsService;

@Component
//@Path("/userdetails")
public class UserDetailsServicesImpl implements UserDetailsServices{
	
	@Autowired
	private UserDetailsService userDetailsService;

	public Response save(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response update(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails findById(String userName) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	

}
