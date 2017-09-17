package com.zccpro.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public final class MyStringUtils {

	/**
	 * 得到一个随机的字符串字段 常用与文件名
	 *  6d33a39d-ebf3-4d18-afef-04e9f795e155 类似的数据
	 * @return
	 */
	public static String getRandomUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static Long getRandomNumber(){
		Random random = new Random();
		return  random.nextLong();
	}
	/**
	 * 获取当钱时间 12 格式
	 * @return
	 */
	public static String getCurrent12Date(){
		return new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date());
	}
	
	/**
	 * 获取当钱时间24 格式
	 * @return
	 */
	public static String getCurrent24Date(){
		return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 获取当钱时间24 格式
	 * @return
	 */
	public static String getCurrentDateString(){
		return new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
	}
	
	public static String getoder(){
		return getCurrentDateString()+new Date().getTime();
	}
	
}
