package com.ymhase.miniTwit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.dao.LoginDaoImp;
import com.ymhase.miniTwit.dto.LoginDto;

@Service
public class LoginService {

	@Autowired
	LoginDaoImp loginDao;

	public boolean login(LoginDto loginDto) {

		return loginDao.isValiduser(loginDto.getUsername(), loginDto.getPassword());

	}

	public String forgotUsername(String email) {

		String username = loginDao.getUsername(email);
		if (username.equals(" ") || username == null) {
			return AppConstant.ERROR_NOT_EXIST;
		}

		return username;

	}

}
