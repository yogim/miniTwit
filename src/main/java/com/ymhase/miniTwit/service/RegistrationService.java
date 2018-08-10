package com.ymhase.miniTwit.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.AppConstant;
import com.ymhase.miniTwit.dao.RegistrationDaoImp;
import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.model.UserModel;

@Service
public class RegistrationService {

	RegistrationDaoImp registrationDao;

	public String registerUser(RegistrationDto registrationDto) {
		
		
		UserModel userModel = new UserModel();
		userModel.setUserid(UUID.randomUUID().toString());
		userModel.setFirstName(registrationDto.getFirstName());
		userModel.setLastName(registrationDto.getLastName());
		userModel.setUserName(registrationDto.getUserName());
		userModel.setEmail(registrationDto.getEmail());
		userModel.setPassword(registrationDto.getPassword());
		userModel.setStatus("A");

		registrationDao = new RegistrationDaoImp();
		if(registrationDao.insertDao(userModel))
			return AppConstant.USER_REGISTERED;
		else
			return AppConstant.ERROR_USER_REGISTERED;

				
	}

}
