package com.ymhase.miniTwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymhase.miniTwit.dao.FollowingDaoImp;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.exception.ErrorCode;

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

	public List<Object> getFollowerList(String userid) throws CustomException {

		List<Object> list = followingDaoimp.getFollowerList(userid);
		if (list.size() == 0) {
			new CustomException(ErrorCode.NOT_FOUND);
		}
		return list;
	}
	
	public List<Object> getFollowingList(String userid) throws CustomException {

		List<Object> list = followingDaoimp.getFollowingList(userid);
		if (list.size() == 0) {
			new CustomException(ErrorCode.NOT_FOUND);
		}
		return list;
	}

}
