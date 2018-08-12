package com.ymhase.miniTwit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.QueriesConstant;
import com.ymhase.miniTwit.mapper.UserModelMapper;
import com.ymhase.miniTwit.model.UserModel;

@Repository
public class UserDaoImp {

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

	public UserModel getUserbyUsernameAndPassword(String username, String password) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("username", username);
		namedParameters.addValue("password", password);

		return (UserModel) jdbctemplate.queryForObject(QueriesConstant.getUserByUernamePassword, namedParameters,
				new UserModelMapper());

	}

	public boolean isValiduser(String username, String password) {

		System.out.println(username + password);

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("username", username);
		namedParameters.addValue("password", password);

		System.out.println(username + password);
		Integer status = jdbctemplate.queryForObject(QueriesConstant.isvalidUser, namedParameters, Integer.class);

		System.out.println(status);

		if (status == 1) {
			return true;
		}

		return false;
	}

	public String getUsername(String email) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("email", email);

		String usernname = jdbctemplate.queryForObject(QueriesConstant.getUsernameByEmail, namedParameters,
				String.class);

		return usernname;
	}

	public UserModel createUser(UserModel userModel) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userModel.getUserid());
		namedParameters.addValue("firstName", userModel.getFirstName());
		namedParameters.addValue("lastName", userModel.getLastName());
		namedParameters.addValue("userName", userModel.getUserName());
		namedParameters.addValue("email", userModel.getEmail());
		namedParameters.addValue("password", userModel.getPassword());

		jdbctemplate.update(QueriesConstant.insertUser, namedParameters);

		return userModel;

	}

	public UserModel getUserByUserID(String userID) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userID);

		return (UserModel) jdbctemplate.queryForObject(QueriesConstant.getUserByUserId, namedParameters,
				new UserModelMapper());

	}

	public void deleteuser(String userid) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userid);

		jdbctemplate.update(QueriesConstant.deleteUser, namedParameters);

	}

}
