package com.kangmin.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Welcome {

	@GetMapping("/welcome") // HTML�� �Ѱ��� ������
	public String welcome(Model model) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		model.addAttribute("key1", list); //[[${key1}]] ��� [a, b]

		Map<String, Object> map = new HashMap<>();
		map.put("a", "value a");
		map.put("b", "value b");
		model.addAttribute("key2", map); //[[${key2}]]��� {a=value a, b=value b}
//[[${key2.a}]], [[${key2['b']}]] ����� value a  value b
		return "welcome";
	}
}
