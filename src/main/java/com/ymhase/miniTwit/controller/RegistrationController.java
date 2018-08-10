package com.ymhase.miniTwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping(method = RequestMethod.POST, value = "/registration")
	public String registerUser(@RequestBody RegistrationDto registrationDto) {
		
		return registrationService.registerUser(registrationDto);

	}

}
