package com.ymhase.miniTwit.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = 9112475790271639014L;

	ErrorCode errorCode;

	public CustomException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
