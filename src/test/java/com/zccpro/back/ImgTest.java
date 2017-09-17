package com.zccpro.back;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.ImgService;
import com.zccpro.domain.Img;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"})  
public class ImgTest {

	@Resource
	private ImgService imgService;
	@Test
	public void testImgSelect(){
		Img img = imgService.selectByProductId(266L);
		String url = img.getUrl();
		System.out.println(url);
	}
	
}
