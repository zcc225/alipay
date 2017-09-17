package com.zccpro.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String toIndex(){
		return "redirect:/product/display/list.do";
	}
}
