package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.model.UserModel;
import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	SessionService sessionService;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) {
		logger.info("Inside login controller");
		UserModel model = userService.getUserbyUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());

		if (model == null) {
			logger.info("User not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid user name or password");
		}

		logger.info("Login Success");
		return ResponseEntity.status(HttpStatus.OK).body(model);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/forgotusername/{email:.+}")
	public ResponseEntity<?> forgotUsername(@PathVariable String email) throws CustomException {
		logger.info("Inside forgot username");

		String username = userService.forgotUsername(email);

		if (username.equals(null) || " ".equals(username)) {
			logger.info("Username not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not registered with this Email ID.");
		}
		logger.info("Username found");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("username", username);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
