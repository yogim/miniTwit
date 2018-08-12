package com.ymhase.miniTwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.dao.FollowingDaoImp;
import com.ymhase.miniTwit.mapper.FollowerMapper;

@Repository
public class FollowingService {
	
	@Autowired
	FollowingDaoImp followingDaoimp;

	public void follow(String userid, String followerID) {

		followingDaoimp.follow(userid, followerID);
	}

	public void unfollow(String userid, String followerID) {
		followingDaoimp.unfollow(userid, followerID);
	}

	public List<FollowerMapper> getFollowerList(String userid) {
		return followingDaoimp.getFollowerList(userid);
	}

	
	
}
