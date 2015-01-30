package com.qph.entity;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
	
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

	@Override
	public void run() {
		System.out.println("Run with 2 wheels");
		
	}
	
	
}
