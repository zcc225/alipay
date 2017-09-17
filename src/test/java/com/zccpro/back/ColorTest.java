package com.zccpro.back;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.ColorService;
import com.zccpro.domain.Color;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"}) 
public class ColorTest {
	@Resource
	private ColorService colorService;
	@Test
	public void colorTest(){
		List<Color> selectColorList = colorService.selectColorList();
		System.out.println();
	}
}
