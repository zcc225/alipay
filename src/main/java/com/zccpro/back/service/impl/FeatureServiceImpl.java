package com.zccpro.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccpro.back.service.FeatureService;
import com.zccpro.dao.FeatureMapper;
import com.zccpro.domain.Feature;
@Service("featureService")
public class FeatureServiceImpl implements FeatureService {

	@Resource
	private FeatureMapper featureMapper;
	public List<Feature> selectFeatureList() {
		return featureMapper.selectFeatureList();
	}

}
