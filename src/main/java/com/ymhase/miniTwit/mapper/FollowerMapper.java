package com.ymhase.miniTwit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ymhase.miniTwit.model.FollowerModel;

public class FollowerMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		FollowerModel followerModel = new FollowerModel();

		followerModel.setFirstname(rs.getString("firstname"));
		followerModel.setLastname(rs.getString("lastname"));
		followerModel.setUserid(rs.getString("userid"));

		return null;
	}

}
