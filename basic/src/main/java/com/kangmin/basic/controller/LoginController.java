package com.kangmin.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class LoginController {
	@GetMapping("/login") // login �̶�� html ����� ��������.
	public String login() {
		return "login";
	}
	@PostMapping("/login") //login�� post������ ���� ����!!
	@ResponseBody
	public String loginPost(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw) {
		
		String dbId = "boot";
		String dbPw = "1234";
		
		if(dbId.equals(id) && dbPw.equals(pw)) {//string�� equals ���������Ѵ�.
			return "�α��� ����";
		}
		
		
		return "�α��� ����";
	}
}
