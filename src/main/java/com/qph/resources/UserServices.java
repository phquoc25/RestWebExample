package com.qph.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserServices {
	
	@GET
	@Path("/detail")
	public Response getUser() {
		return Response
				   .status(200)
				   .entity("getUsers is called").build();
		
	}
}
