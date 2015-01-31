package com.qph.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "UserDetails:byId", query = "from UserDetails where userId=?")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8919394224899768583L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Embedded
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Lob
	private String description;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int usetId) {
		this.userId = usetId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
