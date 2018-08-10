package com.ymhase.miniTwit.dao;

public interface SessionDao {

	public boolean createSessionId(String userId);

	public String getUseridBySessionId(String sessionId);

}
