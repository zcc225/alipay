package com.zccpro.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccpro.back.service.SkuService;
import com.zccpro.dao.ColorMapper;
import com.zccpro.dao.SkuMapper;
import com.zccpro.domain.Color;
import com.zccpro.domain.Sku;
@Service("skuService")
public class SkuServiceImpl implements SkuService {
	@Resource
	private ColorMapper colorMapper;
	@Resource
	private SkuMapper skuMapper;
	public int deleteBySkuId(Long id) {
		return skuMapper.deleteByPrimaryKey(id);
	}

	public int insertSku(Sku record) {
		return skuMapper.insertSelective(record);
	}

	public Sku selectBySkuID(Long id) {
		
		return skuMapper.selectByPrimaryKey(id);
	}

	public List<Sku> selectByProductId(Long id) {
		//TODO
		List<Color> colorList = colorMapper.selectColorList();
		List<Sku> skuList = skuMapper.selectByProductId(id);
		for (Sku sku : skuList) {
			for (Color color : colorList) {
				if(sku.getColorId().equals(color.getId())){
					sku.setColorname(color.getName());
				}
			}
		}
		return skuList;
	}

	public int updateByskuId(Sku record) {
		// TODO Auto-generated method stub
		return skuMapper.updateByPrimaryKeySelective(record);
	}

}
