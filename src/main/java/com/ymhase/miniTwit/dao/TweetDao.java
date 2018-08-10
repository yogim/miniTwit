package com.ymhase.miniTwit.dao;

import java.util.List;

import com.ymhase.miniTwit.mapper.TweetFollowingMapper;
import com.ymhase.miniTwit.mapper.TweetModelMapper;

public interface TweetDao {

	public List<TweetModelMapper> getTweetbyUserID(String userId);

	public List<TweetFollowingMapper> getTweetForFollowing(String userId);

	public boolean deleteTweet(String tweetID);

}
