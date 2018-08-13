package com.ymhase.miniTwit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.dao.TweetDaoImp;
import com.ymhase.miniTwit.dto.TwitDto;
import com.ymhase.miniTwit.model.TwitModel;

@Repository
public class TwitService {

	@Autowired
	TweetDaoImp tweetDao;

	public List<Object> getTweetbyUserID(String userId) {

		return tweetDao.getTweetbyUserID(userId);
	}

	public List<Object> getfollowersTweet(String userId) {

		return tweetDao.getFollowerTwit(userId);
	}

	public void createtwit(String userid, TwitDto twitDto) {

		TwitModel tweetModel = new TwitModel();
		tweetModel.setDescription(twitDto.getTwit());
		tweetModel.setDeletestatus("A");
		tweetModel.setTweeId(UUID.randomUUID().toString());
		tweetModel.setUserId(userid);
		tweetDao.createTwit(userid, tweetModel);
	}
}
