package com.qph.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;



@Path("/user")
public class UserServices {
	
	private Logger logger = Logger.getLogger(UserServices.class);
	@GET
	@Path("/detail")
	public Response getUser() {
		logger.info("enter Userservice.getUser method");
		return Response
				   .status(200)
				   .entity("getUsers is called").build();
		
	}
}
