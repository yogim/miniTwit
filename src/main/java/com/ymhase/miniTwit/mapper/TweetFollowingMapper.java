package com.ymhase.miniTwit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ymhase.miniTwit.model.TwitFollowingModel;

public class TweetFollowingMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TwitFollowingModel tweetFollowingModel = new TwitFollowingModel();
		tweetFollowingModel.setFirstname(rs.getString("firstname"));
		tweetFollowingModel.setLastname(rs.getString("lastname"));
		tweetFollowingModel.setDescription(rs.getString("description"));
		tweetFollowingModel.setUserdID(rs.getString("user_id"));

		return tweetFollowingModel;
	}

}
