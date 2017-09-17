package com.zccpro.back.service;

import com.zccpro.domain.Img;

public interface ImgService {

	Img selectByProductId(Long productId);
}
