package com.ymhase.miniTwit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ymhase.miniTwit.model.TweetFollwingModel;

public class TweetFollowingMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TweetFollwingModel tweetFollowingModel = new TweetFollwingModel();
		tweetFollowingModel.setFirstname("firstname");
		tweetFollowingModel.setLastname("lastname");
		tweetFollowingModel.setDescription("description");
		tweetFollowingModel.setUserdID("user_id");

		return tweetFollowingModel;
	}

}
