package com.zccpro.dao;

import java.util.List;

import com.zccpro.domain.Feature;

public interface FeatureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Feature record);

    int insertSelective(Feature record);

    Feature selectByPrimaryKey(Long id);
    
    List<Feature> selectFeatureList();

    int updateByPrimaryKeySelective(Feature record);

    int updateByPrimaryKey(Feature record);
}