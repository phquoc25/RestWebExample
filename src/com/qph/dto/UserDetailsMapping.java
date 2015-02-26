package com.qph.dto;

import java.util.Date;

import com.qph.model.UserDetails;

public class UserDetailsMapping {
	public static void userDetails2Dto(UserDetails userDetails, UserDetailsDTO userDetailsDto){
		userDetailsDto.setUserId(userDetails.getUserId());
		userDetailsDto.setUserName(userDetails.getUserName());
		userDetailsDto.setJoinedDate(userDetails.getJoinedDate());
	}
	
	public static void dto2userDetails(UserDetails userDetails, UserDetailsDTO userDetailsDto){
		userDetails.setCreatedDate(new Date());
		userDetails.setUserName(userDetailsDto.getUserName());
		userDetails.setAddress(userDetailsDto.getAddress());
		userDetails.setJoinedDate(userDetailsDto.getJoinedDate());
	}
}
