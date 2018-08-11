package com.ymhase.miniTwit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ymhase.miniTwit.model.TweetFollowingModel;

public class TweetFollowingMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TweetFollowingModel tweetFollowingModel = new TweetFollowingModel();
		tweetFollowingModel.setFirstname(rs.getString("firstname"));
		tweetFollowingModel.setLastname(rs.getString("lastname"));
		tweetFollowingModel.setDescription(rs.getString("description"));
		tweetFollowingModel.setUserdID(rs.getString("user_id"));

		return tweetFollowingModel;
	}

}
