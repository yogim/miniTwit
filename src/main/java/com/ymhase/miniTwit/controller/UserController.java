package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.model.UserModel;
import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET, value = "/getuserdetails")
	public Map<String, Object> getUserDetails(HttpServletRequest req, HttpServletResponse resp) throws CustomException{

		Map<String, Object> response = new HashMap<String, Object>();

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		UserModel model = userService.getUserByUserID(userid);

		response.put("user-model", model);

		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteuser")
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws CustomException {

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));
		userService.deleteUser(userid);
		sessionService.deleteSession(sessionService.getUserIdBysessionKey(req.getHeader("x-api-key")));

	}

}
