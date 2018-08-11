package com.ymhase.miniTwit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET, value = "/usersession")
	public String session(HttpServletRequest req, HttpServletResponse response) {

		return sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));
	}
}
