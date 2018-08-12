package com.ymhase.miniTwit.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.QueriesConstant;
import com.ymhase.miniTwit.mapper.FollowerMapper;
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

		jdbctemplate.update(QueriesConstant.follow, namedParameters);

	}

	public void unfollow(String userID, String followingID) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userID);
		namedParameters.addValue("followingID", followingID);

		jdbctemplate.update(QueriesConstant.unfollow, namedParameters);

	}

	public List<FollowerMapper> getFollowerList(String userid) {
		List<FollowerMapper> list ;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userid);

		list = jdbctemplate.query(QueriesConstant.getTweetForFollowing, namedParameters, new TweetFollowingMapper());

		return list;

	}

}
