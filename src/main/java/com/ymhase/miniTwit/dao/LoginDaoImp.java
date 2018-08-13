package com.ymhase.miniTwit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.mapper.UserModelMapper;
import com.ymhase.miniTwit.model.UserModel;

@Repository
public class LoginDaoImp implements LoginDao {

	@Autowired
	NamedParameterJdbcTemplate jdbctemplate;

	public boolean isValiduser(String username, String password) {

		System.out.println(username + password);

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("username", username);
		namedParameters.addValue("password", password);

		System.out.println(username + password);
		UserModel model = (UserModel) jdbctemplate.queryForObject(AppConstant.GET_USER_BY_USERNAME_PASSWORD, namedParameters,
				new UserModelMapper());

		if (model.getUserName().equals(username) && model.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

	public String getUsername(String email) {

		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("email", email);

		String usernname = jdbctemplate.queryForObject(AppConstant.GET_USERNAME_BY_EMAIL, namedParameters,
				String.class);

		return usernname;
	}

}
