package com.zccpro.back.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccpro.back.service.BrandService;
import com.zccpro.constants.Constants;
import com.zccpro.dao.BrandMapper;
import com.zccpro.domain.Brand;
import com.zccpro.domain.vo.BeanQuery;
import com.zccpro.domain.vo.BrandQuery;

import sun.security.action.PutAllAction;
@Service("brandService")
public class BrandServiceImpl implements BrandService {
	@Resource
	private BrandMapper brandMapper;
	
	public List<Brand> selectBrandList() {
		return brandMapper.selectBrandList();
	}
	public Brand selectBrandByID(long id) {
		Brand brand = brandMapper.selectByPrimaryKey(id);
		if(brand.getImgUrl().startsWith("group")){
			brand.setWebSite(Constants.IMG_URL+brand.getImgUrl());
		}else{
			brand.setWebSite(brand.getImgUrl());
		}
		return brand ;
	}
	
	public int deleteBrandById(long id){
		return brandMapper.deleteByPrimaryKey(id);
	}
	public int insertBrand(Brand brand) {
		return brandMapper.insertSelective(brand);
	}
	public int updateBrand(Brand brand) {
		return brandMapper.updateByPrimaryKeySelective(brand);
	}
	public Map<String, Object> selectPageByBrand(Integer pageNo, String name, Boolean isDisplay) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		BrandQuery brandQuery = new BrandQuery();
		
		if(name!=null){
			brandQuery.setName(name);
		}
		if(isDisplay!=null){
			brandQuery.setIsDisplay(isDisplay);
		}
		
		if(pageNo!=null){
			brandQuery.setPageNo(pageNo);
			int startRow = (pageNo-1)*Constants.PAGESIZE;
			brandQuery.setStartRow(startRow);
		}
		
		List<Brand> brandList = brandMapper.selectPageByBrand(brandQuery);
		int totoalCount = brandMapper.selectCountByBrand(brandQuery);
		brandQuery.setTotoalCount(totoalCount);
		brandQuery.setTotalPage(brandQuery.getTotalPage());
		for (Brand brand : brandList) {
			String imgUrl = brand.getImgUrl();
			if(imgUrl==null){
				continue;
			}
			if(imgUrl.startsWith("group")){
				brand.setWebSite(Constants.IMG_URL+imgUrl);
			}else{
				brand.setWebSite(imgUrl);
			}
		}
		map.put("brandList", brandList);
		map.put("totoalcount", totoalCount);
		map.put("brandQuery",brandQuery );
		return map;
	}
	public void deleteBrand(Long[] ids) {
		
		if(ids.length==1){
			brandMapper.deleteByPrimaryKey(ids[0]);
		}else if(ids.length>1){
			int num = brandMapper.deleteByIds(ids);
			System.out.println("删除了多条数据"+num);
		}
	}


}
