package com.ymhase.miniTwit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ymhase.miniTwit.model.TweetModel;

public class TweetModelMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TweetModel tweetModel = new TweetModel();
		tweetModel.setTweeId(rs.getString("tweetid"));
		tweetModel.setUserId(rs.getString("user_id"));
		tweetModel.setDescription(rs.getString("description"));
		tweetModel.setDeletestatus(rs.getString("deletestatus"));

		return tweetModel;
	}

}
