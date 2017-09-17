package com.zccpro.dao;

import java.util.List;

import com.zccpro.domain.Brand;

public interface BrandMapper {

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
    
    List<Brand> selectBrandList();

	List<Brand> selectPageByBrand(Brand brand);
	
	int selectCountByBrand(Brand brand);

	int deleteByPrimaryKey(Long id);
	int deleteByIds(Long[] ids);//删除多条记录。
}