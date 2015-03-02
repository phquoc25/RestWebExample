package com.qph.common;

public enum InterfaceType {
	REST_USERDETAILS_INTERFACE("REST_USERDETAILS_INTERFACE", "UserDetailsREST");
	String interfaceType;
	String logicalName;
	
	InterfaceType(String interfaceType, String logicalName){
		this.interfaceType = interfaceType;
		this.logicalName = logicalName;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public String getLogicalName() {
		return logicalName;
	}
}
