package com.ymhase.miniTwit.model;

public class TweetModel {

	
	private String tweeId;
	private String userId;
	private String description;
	private String deletestatus;

	public String getTweeId() {
		return tweeId;
	}

	public void setTweeId(String tweeId) {
		this.tweeId = tweeId;
	}

	
	public String getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
