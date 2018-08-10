package com.ymhase.miniTwit.service;

import org.springframework.stereotype.Service;
import com.ymhase.miniTwit.dao.UserDaoImp;
import com.ymhase.miniTwit.model.UserModel;

@Service
public class UserService {

	UserDaoImp userDao;

	public UserModel getUser(String id) {

		userDao = new UserDaoImp();
		return userDao.getUser(id);
	}

	public void updateUser(UserModel userModel) {
		userDao = new UserDaoImp();
		userDao.updateUser(userModel);

	}

}
