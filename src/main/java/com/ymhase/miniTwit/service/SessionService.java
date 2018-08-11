package com.ymhase.miniTwit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ymhase.miniTwit.dao.SessionDaoImp;

@Repository
public class SessionService {

	@Autowired
	SessionDaoImp sessionDao;

	public boolean isSessionValid(String sessionKey) {

		return sessionDao.isSessionValid(sessionKey);
	}

	public boolean deleteSession(String sessionKey) {

		return sessionDao.deleteSessionId(sessionKey);
	}

	public boolean createSession(String userId) {

		return sessionDao.createSessionId(userId);
	}

	public String getUserIdBysessionKey(String sessionKey) {

		return sessionDao.getUseridBySessionId(sessionKey);
	}

}
