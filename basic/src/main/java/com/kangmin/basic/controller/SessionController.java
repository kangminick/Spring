package com.kangmin.basic.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kangmin.basic.model.User;

@Controller
public class SessionController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(User user, HttpSession session) {
		//세션은 어디서든지(현재 스프링서버) 사용가능
		session.setAttribute("user", user);
		return "redirect:/main"; //redirect : 여기로 바로 던져줌.
	}

	@GetMapping("/main")
	public String main() {
		return "main";
	}
}