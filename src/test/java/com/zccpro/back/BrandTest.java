package com.zccpro.back;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zccpro.back.service.BrandService;
import com.zccpro.domain.Brand;

@RunWith(SpringJUnit4ClassRunner.class)    
@ContextConfiguration(locations = {"classpath:spring-config.xml"})  
public class BrandTest {
	@Resource
	private BrandService brandService;
	/**
	 * 测试查询品牌列表
	 */
	@Test
	public void testSerlect(){
		List<Brand> list = brandService.selectBrandList();
		System.out.println("");
	}
	
	/**
	 * 测试根据Id查询品牌
	 */
	@Test
	public void testSerlectOne(){
		Brand b = brandService.selectBrandByID(100000000000L);
		System.out.println("");
	}
	/**
	 * 测试插入品牌
	 */
	@Test
	public void testInsert(){
		Brand brand = new Brand();
		brand.setDescription("cs");
		brand.setId(100000000000L);
		brand.setImgUrl("/a/b/c/aaa.png");
		brand.setIsDisplay(true);
		brand.setName("zccpro");
		brand.setSort(1);
		brand.setWebSite("a");
		int insertBrand = brandService.insertBrand(brand);
		System.out.println(insertBrand);
	}
	
	/**
	 * 测试品牌修改
	 */
	@Test
	public void testUptate(){
		Brand brand = new Brand();
		brand.setDescription("cs1");
		brand.setId(100000000000L);
		brand.setImgUrl("/a/b/c/aaa1.png");
		brand.setIsDisplay(true);
		brand.setName("zccpro1");
		brand.setSort(1);
		brand.setWebSite("a1");
		int a = brandService.updateBrand(brand);
		System.out.println(a);
	}
	
	/**
	 * 测试删除品牌对象
	 */
	@Test
	public void testDeleteBrand(){
		int i = brandService.deleteBrandById(100000000000L);
		System.out.println(i);
	}
}

	
