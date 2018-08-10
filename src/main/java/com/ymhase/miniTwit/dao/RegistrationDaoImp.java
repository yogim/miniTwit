package com.ymhase.miniTwit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.QueriesConstant;
import com.ymhase.miniTwit.model.UserModel;

@Repository
public class RegistrationDaoImp implements RegistrationDao {

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
		namedParameters.addValue("status", userModel.getStatus());
		
/*		
		 Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("userid", userModel.getUserid());
		namedParameters.put("firstName", userModel.getFirstName());
		namedParameters.put("lastName", userModel.getLastName());
		namedParameters.put("userName", userModel.getUserName());
		namedParameters.put("email", userModel.getEmail());
		namedParameters.put("password", userModel.getPassword());
		namedParameters.put("status", userModel.getStatus());*/
		
		System.out.println(userModel.getUserid());
		System.out.println(userModel.getFirstName());
		System.out.println(userModel.getLastName());
		System.out.println(userModel.getUserName());
		System.out.println(userModel.getEmail());
		System.out.println(userModel.getPassword());
		System.out.println(userModel.getStatus());

		int entry = jdbctemplate.update(QueriesConstant.insertUser, namedParameters);

		
		
		if (entry == 1)
			return true;
		else
			return false;

	}

}
