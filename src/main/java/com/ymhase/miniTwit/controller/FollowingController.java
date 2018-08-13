package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.service.FollowingService;
import com.ymhase.miniTwit.service.SessionService;

@RestController
public class FollowingController {

	@Autowired
	FollowingService followingService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.POST, value = "/follow/{followerID}")
	public void follow(@PathVariable String followerID, HttpServletRequest req, HttpServletResponse resp) throws CustomException {

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		followingService.follow(userid, followerID);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/unfollow/{followerID}")
	public void unfollow(@PathVariable String followerID, HttpServletRequest req, HttpServletResponse resp) throws CustomException {

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		followingService.unfollow(userid, followerID);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/followers")
	public Map<String, Object> getFollowerList(HttpServletRequest req, HttpServletResponse resp) throws CustomException {

		Map<String, Object> response = new HashMap<String, Object>();
		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		response.put("follower-list", followingService.getFollowerList(userid));

		return response;
	}

}
