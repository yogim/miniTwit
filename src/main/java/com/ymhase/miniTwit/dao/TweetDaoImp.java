package com.ymhase.miniTwit.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.mapper.TweetFollowingMapper;
import com.ymhase.miniTwit.mapper.TweetModelMapper;
import com.ymhase.miniTwit.model.TwitModel;

@Repository
public class TweetDaoImp  {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public List<Object> getTweetbyUserID(String userId) {

		List<Object> list;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userId);

		System.out.println(userId);

		list = jdbctemplate.query(AppConstant.GET_TWEET_BY_USERID, namedParameters, new TweetModelMapper());

		return list;
	}

	public List<Object> getFollowerTwit(String userId) {
		List<Object> list = new ArrayList<Object>();

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userId);

		list = jdbctemplate.query(AppConstant.GET_TWEET_FOR_FOLLOWING, namedParameters, new TweetFollowingMapper());

		return list;

	}

	public boolean deleteTweet(String tweetID) {
		int insertStatus;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("tweetID", tweetID);

		insertStatus = jdbctemplate.update(AppConstant.DELETE_TWEET, namedParameters);

		if (insertStatus == 1)
			return true;
		else
			return false;
	}

	public boolean insertTweet(TwitModel tweetModel) {

		int insertStatus;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("tweetid", tweetModel.getTweeId());
		namedParameters.addValue("userid", tweetModel.getUserId());
		namedParameters.addValue("description", tweetModel.getDescription());
		namedParameters.addValue("deletestatus", tweetModel.getDeletestatus());

		insertStatus = jdbctemplate.update(AppConstant.INSERT_TWEET, namedParameters);

		if (insertStatus == 1)
			return true;
		else
			return false;

	}

	public void createTwit(String userid, TwitModel tweetModel) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("tweetid", tweetModel.getTweeId());
		namedParameters.addValue("userid", tweetModel.getUserId());
		namedParameters.addValue("description", tweetModel.getDescription());
		namedParameters.addValue("deletestatus", tweetModel.getDeletestatus());

		jdbctemplate.update(AppConstant.INSERT_TWEET, namedParameters);

	}

}
