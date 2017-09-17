package com.zccpro.dao;

import java.util.List;

import com.zccpro.domain.Brand;
import com.zccpro.domain.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Long id);
    
    List<Type> selectTypeList();

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}