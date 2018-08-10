package com.ymhase.miniTwit.dao;

import com.ymhase.miniTwit.mapper.UserModelMapper;
import com.ymhase.miniTwit.model.UserModel;

public interface UserDao {

	public UserModelMapper getUserbyId(String userID);

	public boolean createUser(UserModel userModel);

}
