package com.kangmin.basic.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// ctrl + shift + O : ��ü import

@RestController  //��Ʈ�ѷ���� �˷���
public class TestController {
	@GetMapping("/test")
	public String test() {
		return "<h1>Hello~</h1>"; //html �ڵ尡 ���� �ȴ�.
	}
}
