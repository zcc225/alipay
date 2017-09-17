package com.zccpro.dao;

import java.util.List;

import com.zccpro.domain.Sku;

public interface SkuMapper {
    int deleteByPrimaryKey(Long id);
    
    void deleteByProIds(Long[] ids);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

	List<Sku> selectByProductId(Long id);

}