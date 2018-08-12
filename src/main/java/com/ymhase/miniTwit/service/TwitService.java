package com.ymhase.miniTwit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.dao.TweetDaoImp;
import com.ymhase.miniTwit.dto.TwitDto;
import com.ymhase.miniTwit.mapper.TweetFollowingMapper;
import com.ymhase.miniTwit.mapper.TweetModelMapper;
import com.ymhase.miniTwit.model.TweetModel;

@Repository
public class TwitService {

	@Autowired
	TweetDaoImp tweetDao;

	public List<TweetModelMapper> getTweetbyUserID(String userId) {

		return tweetDao.getTweetbyUserID(userId);
	}

	public List<TweetFollowingMapper> getfollowersTweet(String userId) {

		return tweetDao.getFollowerTwit(userId);
	}

	public void createtwit(String userid, TwitDto twitDto) {

		TweetModel tweetModel = new TweetModel();
		tweetModel.setDescription(twitDto.getTwit());
		tweetModel.setDeletestatus("A");
		tweetModel.setTweeId(UUID.randomUUID().toString());
		tweetModel.setUserId(userid);
		tweetDao.createTwit(userid, tweetModel);
	}
}
