package com.ymhase.miniTwit.exception;

import java.util.Date;

public class Error {

	private Date timestamp;
	private String message;
	private String details;

	public Error(String message, String details, Date timestamp) {
		super();
		this.timestamp =  timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
