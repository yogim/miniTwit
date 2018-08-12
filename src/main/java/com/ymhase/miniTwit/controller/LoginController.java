package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.model.UserModel;
import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public Map<String, Object> login(@RequestBody LoginDto loginDto) {

		Map<String, Object> response = new HashMap<String, Object>();

		if ((userService.isUserValid(loginDto.getUsername(), loginDto.getPassword()))) {
			UserModel model = userService.getUserbyUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
			response.put("usermodel", model);
			response.put("session-key", sessionService.createSession(model.getUserid()));
		}

		return response;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/forgotusername/{email:.+}")
	public Map<String, Object> forgotUsername(@PathVariable String email) {

		Map<String, Object> response = new HashMap<String, Object>();

		response.put("username", userService.forgotUsername(email));

		return response;

	}

}
