package com.zccpro.back.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.zccpro.back.service.SkuService;
import com.zccpro.domain.Sku;
@Controller
public class SkuController {

	@Resource
	private SkuService skuService;
	@RequestMapping("/sku/list.do")
	public String list(Long id,Model model){
		List<Sku> skuList = skuService.selectByProductId(id);
		model.addAttribute("skuList", skuList);
		return "back_page/sku/list";
	}
	
	@RequestMapping("/sku/update.do")
	public void update(Sku sku,HttpServletResponse response) throws IOException{
		int id = skuService.updateByskuId(sku);
		JSONObject jo = new JSONObject();
		if(id!=0){
			jo.put("message", "保存成功!");
		}else{
			jo.put("message", "保存失败!");
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jo.toString());
		
	}
}
