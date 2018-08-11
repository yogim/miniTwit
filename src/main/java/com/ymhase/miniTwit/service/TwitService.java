package com.ymhase.miniTwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.dao.TweetDaoImp;
import com.ymhase.miniTwit.mapper.TweetFollowingMapper;
import com.ymhase.miniTwit.mapper.TweetModelMapper;

@Repository
public class TwitService {

	@Autowired
	TweetDaoImp tweetDao;
	
	public List<TweetModelMapper> getTweetbyUserID(String userId){
		
		return tweetDao.getTweetbyUserID(userId);
	}
	
	
public List<TweetFollowingMapper> getfollowersTweet(String userId){
		
		return tweetDao.getFollowerTwit(userId);
	}
}
