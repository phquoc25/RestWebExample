package com.qph.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.qph.model.UserDetails;

@WebService(serviceName="UserDetailsService")
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public class UserDetailsAPI {
	
	public void save(UserDetails user){
		
	}
	
}
