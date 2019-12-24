package com.kangmin.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
public class LoginController {
	@GetMapping("/login") // login 이라는 html 만들고 보여주자.
	public String login() {
		return "login";
	}
	@PostMapping("/login") //login에 post형으로 오면 동작!!
	@ResponseBody
	public String loginPost(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw) {
		
		String dbId = "boot";
		String dbPw = "1234";
		
		if(dbId.equals(id) && dbPw.equals(pw)) {//string은 equals 사용해줘야한다.
			return "로그인 성공";
		}
		
		
		return "로그인 실패";
	}
}
