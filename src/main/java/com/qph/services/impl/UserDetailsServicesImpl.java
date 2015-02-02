package com.qph.services.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qph.model.UserDetails;
import com.qph.services.UserDetailsServices;
import com.qph.userdetails.bo.UserDetailsBo;

@Component
@Path("/userdetails")
public class UserDetailsServicesImpl implements UserDetailsServices{
	
	@Autowired
	private UserDetailsBo userDetailsBo; 
	
	
	public void save(UserDetails userDetails) {
		
	}
	
	@GET
	@Path("/save")
	public Response save1() {
		return Response.status(200).entity("Save1 method called.").build();
	}

	public void update(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}

	public UserDetails findById(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
