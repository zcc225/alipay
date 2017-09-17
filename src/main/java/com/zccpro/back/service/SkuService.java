package com.zccpro.back.service;

import java.util.List;

import com.zccpro.domain.Sku;

public interface SkuService {

	int deleteBySkuId(Long id);

    int insertSku(Sku record);

    Sku selectBySkuID(Long id);

    List<Sku> selectByProductId(Long id);

    int updateByskuId(Sku record);

}
