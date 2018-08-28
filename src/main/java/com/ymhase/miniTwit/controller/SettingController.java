package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.exception.CustomException;
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

	@RequestMapping(method = RequestMethod.PUT, value = "/updateprofile")
	public Map<String, Object> registerUser(@RequestBody RegistrationDto registrationDto, HttpServletRequest req, HttpServletResponse resp) throws CustomException {

		Map<String, Object> response = new HashMap<String, Object>();
		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));
		UserModel model = userService.updateUser(registrationDto,userid);
		logger.info("Registering user");
		
		response.put("user-model", model);
		return response;

	}

}
