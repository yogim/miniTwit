package com.ymhase.miniTwit.dao;

public interface LoginDao {

	public boolean isValiduser(String username, String password);

	public String getUsername(String email);

}
