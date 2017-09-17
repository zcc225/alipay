package com.zccpro.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:spring-config.xml"}) 
public class TestJedis {

	@Resource
	private Jedis jedis;
	@SuppressWarnings("resource")
	@Test
	public void testJedis(){
//		Jedis jedis = new Jedis("192.168.211.133", 6379);
//		jedis.set("productId", "1000000");
		
		String string = jedis.get("productId");
		System.out.println(string);
		Long incr = jedis.incr("productId");
		System.out.println(incr);
	}
}
