package com.ymhase.miniTwit.dto;

import javax.validation.constraints.NotNull;

public class TwitDto {

	@NotNull
	private String twit;

	public String getTwit() {
		return twit;
	}

	public void setTwit(String twit) {
		this.twit = twit;
	}

}
