package com.ymhase.miniTwit.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.mapper.TweetFollowingMapper;

@Repository
public class FollowingDaoImp {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public void follow(String userId, String followingID) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("followingid", UUID.randomUUID().toString());
		namedParameters.addValue("userid", userId);
		namedParameters.addValue("follwinguserid", followingID);

		jdbctemplate.update(AppConstant.FOLLOW, namedParameters);

	}

	public void unfollow(String userID, String followingID) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userID);
		namedParameters.addValue("followingID", followingID);

		jdbctemplate.update(AppConstant.UNFOLLOW, namedParameters);

	}

	public List<Object> getFollowerList(String userid) {
		List<Object> list ;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userid);

		list = jdbctemplate.query(AppConstant.GET_TWEET_FOR_FOLLOWING, namedParameters, new TweetFollowingMapper());

		return list;

	}

}
