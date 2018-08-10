package com.ymhase.miniTwit.dao;

public interface FollowingDao {

	public boolean follow(String userId, String followingID);

	public boolean unfollow(String userID, String followingID);
}
