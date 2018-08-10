package com.ymhase.miniTwit.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.QueriesConstant;

@Repository
public class FollowingDaoImp implements FollowingDao {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public boolean follow(String userId, String followingID) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("followingid", UUID.randomUUID());
		namedParameters.addValue("userid", userId);
		namedParameters.addValue("follwinguserid", followingID);

		int insertStatus = jdbctemplate.update(QueriesConstant.follow, namedParameters);

		if (insertStatus == 1)
			return true;
		else
			return false;
	}

	public boolean unfollow(String userID, String followingID) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userID);
		namedParameters.addValue("followingID", followingID);

		int insertStatus = jdbctemplate.update(QueriesConstant.unfollow, namedParameters);

		if (insertStatus == 1)
			return true;
		else
			return false;
	}

}
