package com.zccpro.back.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CenterController {

	
	
	//入口页面
	@RequestMapping("/control/index.do")
	public String index(){
		return "back_page/index";
	}
	//头
	@RequestMapping(value = "/control/top.do")
	public String top(){
		return "back_page/top";
	}
	//身体
	@RequestMapping(value = "/control/main.do")
	public String main(){
		return "back_page/main";
	}
	//左
	@RequestMapping(value = "/control/left.do")
	public String left(){
		return "back_page/left";
	}
	//右
	@RequestMapping(value = "/control/right.do")
	public String right(){
		return "back_page/right";
	}
	
	
	
	
	
	
	
	
	
	
/*	@Autowired
	private TestTbService testTbService;*/
	
	//测试Springmvc
/*	@RequestMapping(value = "/test/index.do")
	public String index(){
		
		TestTb testTb = testTbService.selectTestTbBy(1);
		
		
		return "index2";
	}*/
}
