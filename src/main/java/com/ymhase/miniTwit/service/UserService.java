package com.ymhase.miniTwit.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.dao.UserDaoImp;
import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.model.UserModel;

@Service
public class UserService {

	@Autowired
	UserDaoImp userDao;

	public String forgotUsername(String email) {

		return userDao.getUsername(email);

	}

	public boolean isUserValid(String username, String password) throws CustomException {

		return userDao.isValiduser(username, password);
	}

	public UserModel getUserbyUsernameAndPassword(String username, String password) {

		return userDao.getUserbyUsernameAndPassword(username, password);
	}

	public UserModel registerUser(RegistrationDto registrationDto) {

		UserModel userModel = new UserModel();
		userModel.setUserid(UUID.randomUUID().toString());
		userModel.setFirstName(registrationDto.getFirstName());
		userModel.setLastName(registrationDto.getLastName());
		userModel.setUserName(registrationDto.getUserName());
		userModel.setEmail(registrationDto.getEmail());
		userModel.setPassword(registrationDto.getPassword());
		return userDao.createUser(userModel);
	}

	public UserModel updateUser(RegistrationDto registrationDto) {

		UserModel userModel = new UserModel();
		userModel.setUserid(UUID.randomUUID().toString());
		userModel.setFirstName(registrationDto.getFirstName());
		userModel.setLastName(registrationDto.getLastName());
		userModel.setUserName(registrationDto.getUserName());
		userModel.setEmail(registrationDto.getEmail());
		userModel.setPassword(registrationDto.getPassword());
		return userDao.updateUser(userModel);
	}
	public UserModel getUserByUserID(String userID) {
		return userDao.getUserByUserID(userID);

	}

	public void deleteUser(String userid) {

		userDao.deleteuser(userid);
	}
}
