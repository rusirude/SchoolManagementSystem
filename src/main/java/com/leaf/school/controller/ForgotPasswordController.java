package com.leaf.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leaf.school.dto.common.AjaxResponseDTO;
import com.leaf.school.service.SysUserService;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping(value = "/forgotPassword",method = RequestMethod.GET)
	public String viewForgotPassword(ModelMap model){
		return "forgotPassword";
	}
	
	@RequestMapping(value = "/forgotPassword/checkUser/{username}",method = RequestMethod.GET)
	public String getUserByUsername(@PathVariable String username,ModelMap model){	 
		
		AjaxResponseDTO response = null;		
		response = sysUserService.checkUserAvailability(username);		
		model.addAttribute(response);
		return "jsonResponse";
	}
	
	@RequestMapping(value = "/forgotPassword/getSecurityQuactions/{username}",method = RequestMethod.GET)
	public String getSecurityQuactionsForUser(@PathVariable String username,ModelMap model){	 
		
		AjaxResponseDTO response = null;		
		response = sysUserService.getSecurityQuestionsForUser(username);
		model.addAttribute(response);
		return "ForgotPassword";
	}
	
	

}
