package com.qph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qph.model.UserDetails;

@Controller
public class UserDetailsController{
	
	@RequestMapping(value="/userdetails", method=RequestMethod.GET)
	public ModelAndView userDetails(){
		return new ModelAndView("userdetails", "command", new UserDetails());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@ModelAttribute("SpringWeb") UserDetails userDetails, ModelMap model) {
		model.addAttribute("name", userDetails.getUserName());
		return "result";
	}

	public void update(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UserDetails userDetails) {
		// TODO Auto-generated method stub
		
	}

	public UserDetails findById(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
