package com.kangmin.basic.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// shift + ctrl + F code 정렬
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	// 1. 출력속도가 빠르다
	// 2. 파일 등을 이용하여 관리가 용이함
	// log 담는 파일만들기
	Logger logger = 
			LoggerFactory.getLogger(this.getClass());
	// shift + Alt + A : 열 편집
	@RequestMapping("/")
	public String home() {
		log.trace("trace!");
		log.debug("debug!"); // 개발단계에서 확인용
		log.info("info!"); // 운용 상 필요한 정보
		log.warn("warn!"); // 메모리 문서 등 경고
		log.error("error!"); // 치명적인 오류
		   
		return "home";
	}
}
