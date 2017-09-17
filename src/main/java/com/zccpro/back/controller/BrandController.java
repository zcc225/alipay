package com.zccpro.back.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zccpro.back.service.BrandService;
import com.zccpro.domain.Brand;

@Controller
public class BrandController {
	Logger logger = Logger.getLogger(BrandController.class);
	@Resource
	private BrandService brandService;
	
	/**
	 * 显示品牌列表，支持查询
	 * @param pageNo
	 * @param name
	 * @param isDisplay
	 * @param model
	 * @return
	 */
	@RequestMapping("/brand/list.do")
	public String list(Integer pageNo,String name ,Boolean isDisplay,Model model){
		Map<String,Object> map = brandService.selectPageByBrand(pageNo, name, isDisplay);
		model.addAllAttributes(map);
		return "back_page/brand/list";
	}
	//去添加
	@RequestMapping(value = "/brand/toAdd.do")
	public String toAdd(){
	
		
		return "back_page/brand/add";
	}
	//添加
	@RequestMapping(value = "/brand/add.do")
	public String add(Brand brand){
		
		brandService.insertBrand(brand);
		
		return "redirect:/brand/list.do";
	}
	//去修改
		@RequestMapping(value = "/brand/toEdit.do")
		public String toEdit(Long id,Model model){
			if(id!=null){
				Brand brand = brandService.selectBrandByID(id);
				model.addAttribute("brand", brand);
			}
			return "back_page/brand/edit";
		}
		//添加
		@RequestMapping(value = "/brand/edit.do")
		public String edit(Brand brand){
			brandService.updateBrand(brand);
			return "redirect:/brand/list.do";
		}
	/**
	 * 删除品牌记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/brand/delete.do")
	public String delete(Integer pageNo,String name ,Boolean isDisplay,Long[] ids,Model model){
		brandService.deleteBrand(ids);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		return "redirect:/brand/list.do";
	}
}
