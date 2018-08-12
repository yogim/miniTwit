package com.ymhase.miniTwit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.TwitDto;
import com.ymhase.miniTwit.mapper.TweetFollowingMapper;
import com.ymhase.miniTwit.mapper.TweetModelMapper;
import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.TwitService;

@RestController
public class TwitController {

	@Autowired
	TwitService twitService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET, value = "/getmytweets")
	public List<TweetModelMapper> getTweetByuserID(HttpServletRequest req, HttpServletResponse response) {

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		return twitService.getTweetbyUserID(userid);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getfollowerstwit")
	public List<TweetFollowingMapper> getfollowerTweet(HttpServletRequest req, HttpServletResponse response) {

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		return twitService.getfollowersTweet(userid);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/twit")
	public void twit(@RequestBody TwitDto twitDto, HttpServletRequest req, HttpServletResponse response) {

		String userid = sessionService.getUserIdBysessionKey(req.getHeader("x-api-key"));

		twitService.createtwit(userid, twitDto);
	}

}
