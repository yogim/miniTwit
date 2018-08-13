package com.ymhase.miniTwit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ymhase.miniTwit.dao.SessionDaoImp;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.exception.ErrorCode;

@Repository
public class SessionService {

	@Autowired
	SessionDaoImp sessionDao;

	public boolean isSessionValid(String sessionKey) throws CustomException {

		if (sessionDao.isSessionValid(sessionKey) == 0)
			throw new CustomException(ErrorCode.UNAUTHORIZED);

		return true;

	}

	public boolean deleteSession(String sessionKey) {

		return sessionDao.deleteSessionId(sessionKey);
	}

	public String createSession(String userId) {

		return sessionDao.createSessionId(userId);
	}

	public String getUserIdBysessionKey(String sessionKey) throws CustomException {

		String userID = sessionDao.getUseridBySessionId(sessionKey);

		return userID;
	}

}
