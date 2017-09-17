package com.zccpro.back;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.FeatureService;
import com.zccpro.domain.Feature;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"}) 
public class FeatureTest {

	@Resource
	private FeatureService featureService;
	@Test
	public void testSelect(){
		List<Feature> selectFeatureList = featureService.selectFeatureList();
		System.out.println();
	}
	
}
