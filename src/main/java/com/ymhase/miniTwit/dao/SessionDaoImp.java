package com.ymhase.miniTwit.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.QueriesConstant;

@Repository
public class SessionDaoImp {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public String getUseridBySessionId(String sessionId) {
		String userID = null;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionId);
		System.out.println(sessionId);

		userID = jdbctemplate.queryForObject(QueriesConstant.getUserIDBySessionID, namedParameters, String.class);

		return userID;
	}

	public String createSessionId(String userId) {
		String sessionKey = UUID.randomUUID().toString();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionKey);
		namedParameters.addValue("userid", userId);
		jdbctemplate.update(QueriesConstant.createSession, namedParameters);
		return sessionKey;

	}

	public boolean deleteSessionId(String sessionid) {

		int insertStatus;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionid);

		insertStatus = jdbctemplate.update(QueriesConstant.deleteSession, namedParameters);
		if (insertStatus == 1)
			return true;
		else
			return false;

	}

	public boolean isSessionValid(String sessionid) {

		Integer insertStatus;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionid);

		insertStatus = jdbctemplate.queryForObject(QueriesConstant.isSessionValid, namedParameters, Integer.class);
		if (insertStatus == 1)
			return true;
		else
			return false;

	}
}
