package com.ymhase.miniTwit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.exception.ErrorCode;
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

		mapper = (UserModelMapper) jdbctemplate.query(AppConstant.GET_USER_BY_USERID, namedParameters,
				new UserModelMapper());

		return mapper;
	}

	public UserModel getUserbyUsernameAndPassword(String username, String password) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("username", username);
		namedParameters.addValue("password", password);

		return (UserModel) jdbctemplate.queryForObject(AppConstant.GET_USER_BY_USERNAME_PASSWORD, namedParameters,
				new UserModelMapper());

	}

	public boolean isValiduser(String username, String password) throws CustomException {

		System.out.println(username + password);

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("username", username);
		namedParameters.addValue("password", password);

		Integer status = jdbctemplate.queryForObject(AppConstant.IS_USER_VALID, namedParameters, Integer.class);

		if (status != 1) {

			throw new CustomException(ErrorCode.NOT_FOUND);
		}

		return true;
	}

	public String getUsername(String email) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("email", email);

		String usernname = jdbctemplate.queryForObject(AppConstant.GET_USERNAME_BY_EMAIL, namedParameters,
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

		jdbctemplate.update(AppConstant.INSERT_USER, namedParameters);

		return userModel;

	}
	
	
	
	public UserModel updateUser(UserModel userModel) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userModel.getUserid());
		namedParameters.addValue("firstName", userModel.getFirstName());
		namedParameters.addValue("lastName", userModel.getLastName());
		namedParameters.addValue("userName", userModel.getUserName());
		namedParameters.addValue("email", userModel.getEmail());
		namedParameters.addValue("password", userModel.getPassword());

		jdbctemplate.update(AppConstant.INSERT_USER, namedParameters);

		return userModel;

	}


	public UserModel getUserByUserID(String userID) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userID);

		return (UserModel) jdbctemplate.queryForObject(AppConstant.GET_USER_BY_USERID, namedParameters,
				new UserModelMapper());

	}

	public void deleteuser(String userid) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userid);

		jdbctemplate.update(AppConstant.DELETE_USER, namedParameters);

	}

}
