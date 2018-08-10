package com.ymhase.miniTwit.dao;

import com.ymhase.miniTwit.model.UserModel;

public interface UserDao {

	public UserModel getUserbyId(String id);

	public UserModel getUserLW(String id);
	
	public UserModel createUser(UserModel userModel);

}
