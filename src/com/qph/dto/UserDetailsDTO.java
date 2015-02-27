package com.qph.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.qph.model.Address;

@Component("userDetaisDTO")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@XmlRootElement
public class UserDetailsDTO implements InitializingBean{
	private int userId;
	private String userName;
	private Date joinedDate;
	private Address address;
	private List<Integer> vehicleIds;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Integer> getVehicleIds() {
		return vehicleIds;
	}
	public void setVehicleIds(List<Integer> vehicleIds) {
		this.vehicleIds = vehicleIds;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("UserDetailsDTO is initialized.");
		
	}
}
