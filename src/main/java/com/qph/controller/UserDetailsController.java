package com.qph.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qph.model.UserDetails;
import com.qph.service.UserDetailsService;

@Controller
@RequestMapping(value="/userdetails")
public class UserDetailsController{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView userDetails(){
		return new ModelAndView("userdetails", "command", new UserDetails());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userDetails1") UserDetails userDetails) {
		userDetailsService.save(userDetails);
		ModelAndView modelAndView = new ModelAndView("result");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public UserDetails saveJson(@RequestBody UserDetails userDetails){
		userDetails.setCreatedDate(new Date());
		userDetailsService.save(userDetails);
		return userDetails;
	}
	
	
	public void update(UserDetails userDetails) {
		
	}

	public void delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public UserDetails findById(@PathVariable("userId") String userId) {
		UserDetails userDetails = userDetailsService.findById(userId);
		return userDetails;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public List getAllUsers() {
		return userDetailsService.getAllUsers();
	}
	
}
