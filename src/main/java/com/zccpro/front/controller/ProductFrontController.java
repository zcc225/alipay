package com.zccpro.front.controller;


import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zccpro.back.service.ProductService;
import com.zccpro.domain.vo.ProductQuery;
@Controller
public class ProductFrontController {
	
	@Resource
	ProductService productservice;
	@SuppressWarnings("unchecked")
	@RequestMapping("/product/display/list.do")
	public String list(Integer pageNo, String keyword, Long brandId, String price, Model model) throws SolrServerException{
		Map<String,Object> hashMap = productservice.selectProductFromSolr(pageNo, keyword, brandId, price);
		model.addAllAttributes(hashMap);
		return "/front_page/product/product";
	}
}
