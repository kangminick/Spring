package com.kangmin.basic.model;

import lombok.Data;

@Data //lombok���� �ؿ� get set�� �ڵ����� ����� �ְ� ���ش�?
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