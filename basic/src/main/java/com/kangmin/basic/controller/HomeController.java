package com.kangmin.basic.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// shift + ctrl + F code ����
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	// 1. ��¼ӵ��� ������
	// 2. ���� ���� �̿��Ͽ� ������ ������
	// log ��� ���ϸ����
	Logger logger = 
			LoggerFactory.getLogger(this.getClass());
	// shift + Alt + A : �� ����
	@RequestMapping("/")
	public String home() {
		log.trace("trace!");
		log.debug("debug!"); // ���ߴܰ迡�� Ȯ�ο�
		log.info("info!"); // ��� �� �ʿ��� ����
		log.warn("warn!"); // �޸� ���� �� ���
		log.error("error!"); // ġ������ ����
		   
		return "home";
	}
}
