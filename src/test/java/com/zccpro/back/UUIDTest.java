package com.zccpro.back;

import java.util.UUID;

import org.junit.Test;

import com.zccpro.utils.MyStringUtils;

public class UUIDTest {

	@Test
	public void testUUID(){
		UUID uuid = UUID.randomUUID();
		String string = uuid.toString();
		System.out.println(string);
	}
	
	@Test
	public void testRandomNumber(){
		Long randomNumber = MyStringUtils.getRandomNumber();
		System.out.println(randomNumber);
	}
	
}
