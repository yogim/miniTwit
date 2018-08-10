package com.ymhase.miniTwit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.model.UserModel;
import com.ymhase.miniTwit.service.UserService;

@RestController

public class UserController {

	@Autowired
	UserService userservice;

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public UserModel getuser(@PathVariable String id) {

		return userservice.getUser(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void updateUser( @RequestBody UserModel userModel) {

		userservice.updateUser(userModel);

	}

}
