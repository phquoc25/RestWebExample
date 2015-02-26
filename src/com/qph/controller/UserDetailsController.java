package com.qph.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qph.dto.UserDetailsDTO;
import com.qph.dto.UserDetailsMapping;
import com.qph.model.UserDetails;
import com.qph.service.UserDetailsService;

@Controller
@RequestMapping(value = "/userdetails")
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserDetailsDTO userDetailsDto;
	
	@Autowired
	private UserDetails userDetails;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView userDetails() {
		return new ModelAndView("userdetails", "command", new UserDetails());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView save(
			@ModelAttribute("userDetails1") UserDetails userDetails) {
		getUserDetailsService().save(userDetails);
		ModelAndView modelAndView = new ModelAndView("result");
		return modelAndView;
	}
	
	/**
	 * REST GET method 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public UserDetailsDTO findById(@PathVariable("userId") int userId) {
		userDetails = getUserDetailsService().findById(userId);
		
		// Get the DTO object from ApplicationContext and then map the information from userDetails entity
		UserDetailsMapping.userDetails2Dto(userDetails, userDetailsDto);
		
		return userDetailsDto;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<UserDetailsDTO> getAllUsers() {
		List<UserDetails> allUsers = getUserDetailsService().getAllUsers();
		List<UserDetailsDTO> returnValues = new ArrayList<UserDetailsDTO>();
		Iterator<UserDetails> iterator = allUsers.iterator();
		while(iterator.hasNext()){
			userDetails = iterator.next();
			UserDetailsMapping.userDetails2Dto(userDetails, userDetailsDto);
			returnValues.add(userDetailsDto);
		}
		return returnValues;
	}
	
	/**
	 * REST POST method
	 * @param userDetailsDto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public boolean saveJson(@RequestBody UserDetailsDTO userDetailsDto) throws Exception{
		boolean returnValue = false;
		try {
			UserDetailsMapping.dto2userDetails(userDetails, userDetailsDto);

			getUserDetailsService().save(userDetails);
			returnValue = true;
		} catch (Exception e) {
			throw e;
		}

		return returnValue;
	}
	
	/**
	 * REST PUT method
	 * @param userDetailsDto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public boolean update(@RequestBody UserDetailsDTO userDetailsDto) {
		int userId = userDetailsDto.getUserId();
		userDetails = getUserDetailsService().findById(userId);
		if(userDetails != null){
			UserDetailsMapping.dto2userDetails(userDetails, userDetailsDto);
			userDetailsService.update(userDetails);
		} else {
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public boolean delete(@PathVariable("userId") int userId) {
		userDetails = userDetailsService.findById(userId);
		if(userDetails != null){
			userDetailsService.delete(userDetails);
		} else {
			return false;
		}
		return true;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public UserDetailsDTO getUserDetailsDto() {
		return userDetailsDto;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

}
