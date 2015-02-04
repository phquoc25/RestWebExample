package com.qph.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application{
	
	 public Set<Class<?>> getClasses() {
	        Set<Class<?>> s = new HashSet<Class<?>>();
	        s.add(UserServices.class);
	        s.add(UserDetailsServicesImpl.class);
	        return s;
	    }
}
