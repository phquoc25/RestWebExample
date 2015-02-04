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
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Entity
@NamedQuery(name = "UserDetails:byId", query = "from UserDetails where userId=?")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
@Table(name = "USER_DETAILS")
@Repository("userDetails")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8919394224899768583L;
	@Autowired
	@Transient
	private MessageSource messageSource;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@Autowired
	@Qualifier(value="userDetailsRelated")
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", joinedDate=");
		builder.append(joinedDate);
		builder.append(", address=");
		builder.append(address);
		builder.append(", vehicles=");
		builder.append(vehicles);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	public void showAddress() {
		System.out.println(messageSource.getMessage("userDetails.address.show", null, "Default showing", null));
		System.out.println(messageSource.getMessage("userDetails.address.detail", 
											new Object[]{this.userName, address.getStreet(), address.getDistrict(), address.getCity()},
											"Default address", null));
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
