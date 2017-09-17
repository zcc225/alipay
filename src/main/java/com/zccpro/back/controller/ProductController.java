package com.zccpro.back.controller;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zccpro.back.service.BrandService;
import com.zccpro.back.service.ColorService;
import com.zccpro.back.service.FeatureService;
import com.zccpro.back.service.ProductService;
import com.zccpro.back.service.TypeService;
import com.zccpro.domain.Brand;
import com.zccpro.domain.Color;
import com.zccpro.domain.Feature;
import com.zccpro.domain.Img;
import com.zccpro.domain.Product;
import com.zccpro.domain.Type;
@Controller
public class ProductController {
	@Resource
	private ProductService productservice;
	@Resource
	private BrandService brandService;
	@Resource
	private TypeService typeService;
	@Resource
	private FeatureService featureService;
	@Resource
	private ColorService colorService;
	@RequestMapping("/product/list.do")
	private String list(Integer pageNo,String name,Long brandId,Boolean isShow,Model model){
		
		HashMap<String, Object> map = productservice.selectProductListByBean(name, brandId, isShow, pageNo);
		model.addAllAttributes(map);
		
		List<Brand> brandList = brandService.selectBrandList();
		model.addAttribute("brandList", brandList);
		
		return "back_page/product/list";
	}
	
	@RequestMapping("/product/delete.do")
	private String delete(Long[] ids,Integer pageNo,String name,Long brandId,Boolean isShow,Model model){
		
		productservice.deleteByIds(ids);
		return "redirect:/product/list.do?pageNo="+pageNo;
	}
	
	@RequestMapping("/product/toAdd.do")
	private String toAdd(Integer pageNo,String name,Long brandId,Boolean isShow,Model model){
		
		List<Brand> brandList = brandService.selectBrandList();
		model.addAttribute("brandList", brandList);
		
		List<Type> typeList = typeService.selectTypeList();
		model.addAttribute("typeList", typeList);
		
		List<Feature> featureList = featureService.selectFeatureList();
		model.addAttribute("featureList", featureList);
		
		List<Color> colorList = colorService.selectColorList();
		model.addAttribute("colorList", colorList);
		return "back_page/product/add";
	}
	
	@RequestMapping("/product/add.do")
	private String add(Product product){
		productservice.insertProduct(product);
		return "redirect:/product/list.do";
	}
	
	@RequestMapping("/product/toEdit.do")
	private String toedit(Long id,Model model){
		
		List<Brand> brandList = brandService.selectBrandList();
		model.addAttribute("brandList", brandList);
		
		List<Type> typeList = typeService.selectTypeList();
		model.addAttribute("typeList", typeList);
		
		List<Feature> featureList = featureService.selectFeatureList();
		model.addAttribute("featureList", featureList);
		
		List<Color> colorList = colorService.selectColorList();
		model.addAttribute("colorList", colorList);
		
		Product product = productservice.selectByID(id);
		model.addAttribute("product", product);
		return "back_page/product/edit";
	}
	
	@RequestMapping("/product/edit.do")
	private String edit(Product product){
		productservice.updateByIDSelective(product);
		return "redirect:/product/list.do";
	}
		
	@RequestMapping("/product/isShow.do")
	private String isShow(Long[] ids,Integer pageNo){
			
		productservice.isShow(ids);
		
		return "redirect:/product/list.do?pageNo="+pageNo;
	}
	
	@RequestMapping("/product/noShow.do")
	private String noShow(Long[] ids,Integer pageNo){
		
		productservice.noShow(ids);
		
		return "redirect:/product/list.do?pageNo="+pageNo;
	}
}
