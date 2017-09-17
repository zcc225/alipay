package com.zccpro.back.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccpro.back.service.ColorService;
import com.zccpro.dao.ColorMapper;
import com.zccpro.domain.Color;
@Service("colorService")
public class ColorServiceImpl implements ColorService {

	@Resource
	private ColorMapper colorMapper;
	public List<Color> selectColorList() {
		return colorMapper.selectColorList();
	}

}
