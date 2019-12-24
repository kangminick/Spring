package com.kangmin.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {
	@GetMapping("req/get") //µÈ´Ù
	@RequestMapping(value = "req/get", method = RequestMethod.GET)
	public String get() {
		return "GET";
	}

	@PostMapping("req/post") //¾ÈµÈ´Ù
	@RequestMapping(value = "req/post", method = RequestMethod.POST)
	public String post() {
		return "POST";
	}
	@PutMapping("req/put") //¹Ø¿¡ ²¨¶û µÑÁß¿¡ ÇÏ³ª¸¸ ¾¸ À§¿¡²¨°¡ ¿äÁò¹æ½Ä
//	@RequestMapping(value="req/put", method=RequestMethod.PUT)
	public String put() {
	return "PUT";
	}
	@DeleteMapping("req/delete")
//	@RequestMapping(value="req/delete", method=RequestMethod.DELETE)
	public String delete() {
	return "DELETE";
	}

}