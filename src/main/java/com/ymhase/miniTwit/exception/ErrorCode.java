package com.ymhase.miniTwit.exception;

public enum ErrorCode {

	NOT_FOUND("404", "RESOURCE NOT FOUND"), BAD_REQUEST("400", "BAD REQUEST"), UNSUPPORTED("415",
			"BAD REQUEST"), SERVER_ERROR("500", "SERVER ERROR"), UNAUTHORIZED("401", "UNAUTHORIZED");

	private final String code;
	private final String message;

	ErrorCode(String code, String message) {

		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return code + ": " + message;
	}

}
