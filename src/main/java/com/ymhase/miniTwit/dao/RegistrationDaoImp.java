package com.ymhase.miniTwit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.model.UserModel;

@Repository
public class RegistrationDaoImp  {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public boolean insertDao(UserModel userModel) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("userid", userModel.getUserid());
		namedParameters.addValue("firstName", userModel.getFirstName());
		namedParameters.addValue("lastName", userModel.getLastName());
		namedParameters.addValue("userName", userModel.getUserName());
		namedParameters.addValue("email", userModel.getEmail());
		namedParameters.addValue("password", userModel.getPassword());

		jdbctemplate.queryForRowSet(AppConstant.INSERT_USER, namedParameters);

		return true;

	}

}
