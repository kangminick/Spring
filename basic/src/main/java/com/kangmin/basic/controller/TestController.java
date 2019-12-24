package com.kangmin.basic.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// ctrl + shift + O : 전체 import

@RestController  //컨트롤러라고 알려준
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "<h1>Hello~</h1>"; //html 코드가 들어가도 된다.
	}
}
