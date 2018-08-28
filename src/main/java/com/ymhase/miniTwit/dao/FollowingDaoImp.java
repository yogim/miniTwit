package com.ymhase.miniTwit.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.mapper.FollowerMapper;

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
		namedParameters.addValue("following_id", userid);
		System.out.println(userid);

		list = jdbctemplate.query(AppConstant.FOLLOWER_LIST, namedParameters, new FollowerMapper());

		return list;

	}

	public List<Object> getFollowingList(String userid) {
		List<Object> list ;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("follower_id", userid);
		System.out.println(userid);
		list = jdbctemplate.query(AppConstant.FOLLOWING_LIST, namedParameters, new FollowerMapper());

		return list;

	}

}
