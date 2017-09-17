package com.zccpro.back.service;

import java.util.List;
import java.util.Map;

import com.zccpro.domain.Brand;


public interface BrandService {

	List<Brand> selectBrandList();
	Brand selectBrandByID(long id);
	int deleteBrandById(long id);
	int insertBrand(Brand brand);
	int updateBrand(Brand brand);
	Map<String, Object> selectPageByBrand(Integer pageNo, String name, Boolean isDisplay);
	void deleteBrand(Long[] ids);
}
