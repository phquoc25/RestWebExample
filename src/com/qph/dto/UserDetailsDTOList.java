package com.qph.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="userdetails")
public class UserDetailsDTOList {
	int count;
	List<UserDetailsDTO> users;
	
	public UserDetailsDTOList() {
	}
	
	public UserDetailsDTOList(List<UserDetailsDTO> users) {
		this.users = users;
		this.count = users.size();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="userdetail")
	public List<UserDetailsDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDetailsDTO> users) {
		this.users = users;
	}
}
