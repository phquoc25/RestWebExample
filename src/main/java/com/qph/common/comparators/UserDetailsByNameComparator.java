package com.qph.common.comparators;

import java.util.Comparator;

import com.qph.model.UserDetails;

public class UserDetailsByNameComparator implements Comparator<UserDetails>{

	public int compare(UserDetails user1, UserDetails user2) {
		return user1.getUserName().compareTo(user2.getUserName());
	}

}
