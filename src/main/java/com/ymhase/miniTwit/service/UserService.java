package com.ymhase.miniTwit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ymhase.miniTwit.dao.UserDaoImp;
import com.ymhase.miniTwit.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserDaoImp userDao;

}
