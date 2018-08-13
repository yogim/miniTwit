package com.ymhase.miniTwit.dao;

import java.util.List;

import com.ymhase.miniTwit.mapper.TweetFollowingMapper;
import com.ymhase.miniTwit.mapper.TweetModelMapper;
import com.ymhase.miniTwit.model.TwitModel;

public interface TweetDao {

	public List<TweetModelMapper> getTweetbyUserID(String userId);

	public List<TweetFollowingMapper> getFollowerTwit(String userId);

	public boolean deleteTweet(String tweetID);
	
	public boolean insertTweet(TwitModel tweetModel);

}
