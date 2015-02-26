package com.qph.model;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
	
	private String SteeringHandle;
	private int height;

	public TwoWheeler(String sterringHandle) {
		this.SteeringHandle = sterringHandle;
	}
	
	public TwoWheeler(String sterringHandle, int height) {
		this.SteeringHandle = sterringHandle;
		this.height = height;
	}
	
	public String getSteeringHandle() {
		return SteeringHandle;
	}

/*	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}*/

	public int getHeight() {
		return height;
	}

	@Override
	public void run() {
		System.out.println("Run with 2 wheels");
		
	}
	
	
}
