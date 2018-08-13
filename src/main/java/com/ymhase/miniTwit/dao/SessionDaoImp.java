package com.ymhase.miniTwit.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.exception.ErrorCode;

@Repository
public class SessionDaoImp {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public String getUseridBySessionId(String sessionId) throws CustomException {
		String userID = null;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionId);
		System.out.println(sessionId);

		userID = jdbctemplate.queryForObject(AppConstant.GET_USERID_BYSESSION, namedParameters, String.class);

		if (userID.equals(null) || " ".equals(userID))
			throw new CustomException(ErrorCode.NOT_FOUND);

		return userID;
	}

	public String createSessionId(String userId) {
		String sessionKey = UUID.randomUUID().toString();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionKey);
		namedParameters.addValue("userid", userId);
		jdbctemplate.update(AppConstant.CREATE_SESSION, namedParameters);
		return sessionKey;

	}

	public boolean deleteSessionId(String sessionid) {

		int insertStatus;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionid);

		insertStatus = jdbctemplate.update(AppConstant.DELETE_SESSION, namedParameters);
		if (insertStatus == 1)
			return true;
		else
			return false;

	}

	public boolean isSessionValid(String sessionid) throws CustomException {

		Integer insertStatus;

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("sessionid", sessionid);

		insertStatus = jdbctemplate.queryForObject(AppConstant.ISSESSION_VALID, namedParameters, Integer.class);

		if (insertStatus != 1)
			throw new CustomException(ErrorCode.UNAUTHORIZED);

		return true;

	}
}
