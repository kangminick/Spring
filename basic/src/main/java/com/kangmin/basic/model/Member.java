package com.kangmin.basic.model;

import lombok.Data;

@Data //lombok에서 밑에 get set을 자동으로 만들수 있게 해준다?
public class Member {
	private String name;
	private String userId;
	private String userPassword;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}