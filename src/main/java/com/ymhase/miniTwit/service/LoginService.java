package com.ymhase.miniTwit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.dao.LoginDaoImp;
import com.ymhase.miniTwit.dao.UserDao;
import com.ymhase.miniTwit.dao.UserDaoImp;
import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.mapper.UserModelMapper;

@Service
public class LoginService {

	@Autowired
	LoginDaoImp loginDao;

	@Autowired
	UserDaoImp userDao;
	
	
/*
	public UserModelMapper login(LoginDto loginDto) {
		UserModelMapper userModel = new UserModelMapper();
		if (loginDao.isValiduser(loginDto.getUsername(), loginDto.getPassword())) {
			userModel = userDao.getUserbyUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		}

		return userModel;

	}

	public String forgotUsername(String email) {

		String username = loginDao.getUsername(email);
		if (username.equals(" ") || username == null) {
			return AppConstant.ERROR_NOT_EXIST;
		}

		return username;

	}*/

}
