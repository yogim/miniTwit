package com.ymhase.miniTwit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ymhase.miniTwit.model.UserModel;

public class UserModelMapper implements RowMapper<Object> {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel userModel = new UserModel();
		userModel.setUserid(rs.getString("user_id"));
		userModel.setFirstName(rs.getString("firstname"));
		userModel.setLastName(rs.getString("lastname"));
		userModel.setUserName(rs.getString("username"));
		userModel.setEmail(rs.getString("email"));
		userModel.setPassword(rs.getString("password"));
		userModel.setStatus(null);

		return userModel;
	}

}
