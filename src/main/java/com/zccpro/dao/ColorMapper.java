package com.zccpro.dao;

import java.util.List;

import com.zccpro.domain.Color;

public interface ColorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Color record);

    int insertSelective(Color record);

    Color selectByPrimaryKey(Long id);
    
    List<Color> selectColorList();

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);
}