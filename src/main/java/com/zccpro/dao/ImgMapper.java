package com.zccpro.dao;

import com.zccpro.domain.Img;

public interface ImgMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByproductId(Long id);
    void deleteByProIds(Long[] ids);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Long id);
    
    Img selectByProductId(Long productId);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}