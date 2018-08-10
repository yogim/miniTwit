package com.ymhase.miniTwit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.QueriesConstant;
import com.ymhase.miniTwit.mapper.UserModelMapper;
import com.ymhase.miniTwit.model.UserModel;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public UserModelMapper getUserbyId(String userId) {

		UserModelMapper mapper = new UserModelMapper();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userId", userId);

		mapper = (UserModelMapper) jdbctemplate.query(QueriesConstant.getUserByUserId, namedParameters,
				new UserModelMapper());

		return mapper;
	}

	public boolean createUser(UserModel userModel) {

		int insertStatus;

		UserModelMapper mapper = new UserModelMapper();
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userModel.getUserid());
		namedParameters.addValue("firstName", userModel.getFirstName());
		namedParameters.addValue("lastName", userModel.getLastName());
		namedParameters.addValue("userName", userModel.getUserName());
		namedParameters.addValue("email", userModel.getEmail());
		namedParameters.addValue("password", userModel.getPassword());
		namedParameters.addValue("status", "A");

		insertStatus = jdbctemplate.update(QueriesConstant.insertUser, namedParameters);

		if (insertStatus == 1)
			return true;
		else
			return false;
	}

}
