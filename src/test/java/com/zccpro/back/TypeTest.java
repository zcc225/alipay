package com.zccpro.back;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.TypeService;
import com.zccpro.domain.Type;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"})  
public class TypeTest {

	@Resource
	TypeService typeService;
	@Test
	public void TypeSelectTest(){
		List<Type> typeList = typeService.selectTypeList();
		System.out.println(typeList);
	}
}
