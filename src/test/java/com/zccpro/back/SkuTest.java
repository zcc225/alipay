package com.zccpro.back;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.SkuService;
import com.zccpro.dao.SkuMapper;
import com.zccpro.domain.Sku;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class SkuTest {

	@Resource
	private SkuService skuService;
	
	@Resource 
	private SkuMapper skuMapper;
	
	@Test
	public void testSku(){
//		Sku selectBySkuID = skuService.selectBySkuID(52L);
//		System.out.println(selectBySkuID.toString());
////		List<Sku> selectByProductId = skuService.selectByProductId(252L);
////		for (Sku sku : selectByProductId) {
////			System.out.println(sku.toString());
////		}
////		int deleteBySkuId = skuService.deleteBySkuId(687L);
////		System.out.println(deleteBySkuId);
//		selectBySkuID.setId(2010L);
//		selectBySkuID.setUpdateTime(new Date());
//		int insertSku = skuService.insertSku(selectBySkuID);
//		System.out.println(insertSku);
		System.out.println("aa");
		List<Sku> list = skuMapper.selectByProductId(252L);
		System.out.println(list.get(0).getPrice());
	}
	
}
