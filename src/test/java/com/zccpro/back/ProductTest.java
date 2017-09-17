package com.zccpro.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.dao.ProductMapper;
import com.zccpro.domain.Product;
@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"})  
public class ProductTest {
	@Resource
	ProductMapper productMapper;
	@Test//查询商品列表
	public void selectProductList(){
		List<Product> selectProductList = productMapper.selectProductList();
		for (Product product : selectProductList) {
			System.out.println(product.toString());
		}
	}
	
	@Test
	public void insertTest(){
		/*SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatfdate = Format.format(new Date());*/
		Product product = new Product();
//		Product product1 = productMapper.selectByPrimaryKey(253L);
//		product1.setId(1000003L);
		product.setBrandId(10000011L);
		product.setCheckTime(new Date());
		product.setCheckUserId("001");
		product.setColors("黄色");
		product.setCreateTime(new Date());
		product.setCreateUserId("002");
		product.setFeatures("22");
		product.setId(1000004L);
		product.setIsCommend(true);
		product.setIsDel(true);
		product.setIsHot(true);
		product.setIsNew(true);
		product.setIsShow(true);
		product.setName("aaa");
		product.setPackageList("aa");
		product.setSales(1);
		product.setSizes("aa");
		product.setTypeId(1000L);
		product.setWeight(20F);
		int insertSelective = productMapper.insertSelective(product);
		
		System.out.println(insertSelective);
	}
	@Test
	public void selectByID(){
		Product product = productMapper.selectByPrimaryKey(253L);
		System.out.println(product);
	}
	
	@Test
	public void updateByID(){
		Product product1 = productMapper.selectByPrimaryKey(1000002L);
		product1.setCheckTime(new Date());
		productMapper.updateByPrimaryKeySelective(product1);
	}
	@Test
	public void selectPro(){
		Product product1 = productMapper.selectByPrimaryKey(1000002L);
		Date checkTime = product1.getCheckTime();
		System.out.println(checkTime.toString());
	}
}
