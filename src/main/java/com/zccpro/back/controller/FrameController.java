package com.zccpro.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模板  跳转
 * @author lx
 *
 */
@Controller
@RequestMapping(value = "/control")
public class FrameController {

	//商品身体
	@RequestMapping(value = "/frame/product_main.do")
	public String product_main(){
		return "back_page/frame/product_main";
	}
	//商品身体  左
	@RequestMapping(value = "/frame/product_left.do")
	public String product_left(){
		return "back_page/frame/product_left";
	}
}
