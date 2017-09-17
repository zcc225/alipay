package com.zccpro.back.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zccpro.back.service.ImgService;
import com.zccpro.dao.ImgMapper;
import com.zccpro.domain.Img;
@Service("imgService")
public class ImgServiceImpl implements ImgService {

	@Resource
	private ImgMapper imgMapper;
	public Img selectByProductId(Long productId) {
		return  imgMapper.selectByProductId(productId);
	}

}
