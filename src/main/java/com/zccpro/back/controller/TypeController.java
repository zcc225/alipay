package com.zccpro.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TypeController {
	@RequestMapping("/type/list.do")
	public String list(){
		return "back_page/type/list";
	}
}
