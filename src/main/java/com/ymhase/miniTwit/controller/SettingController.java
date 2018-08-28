package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.model.UserModel;
import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class SettingController {

	@Autowired
	UserService userService;

	@Autowired
	SessionService sessionService;

	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/updateprofile")
	public Map<String, Object> registerUser(@RequestBody RegistrationDto registrationDto) {

		Map<String, Object> response = new HashMap<String, Object>();
		UserModel model = userService.registerUser(registrationDto);
		String sessionKey = sessionService.createSession(model.getUserid());
		logger.info("Registering user");
		response.put("user-model", model);
		response.put("session-key", sessionKey);
		return response;

	}

}
