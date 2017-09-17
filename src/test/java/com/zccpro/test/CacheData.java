package com.zccpro.test;

import java.util.HashMap;

public class CacheData {
 public static HashMap<String, Object>  picMap = new HashMap<String, Object>();

public static HashMap<String, Object> getPicMap() {
	return picMap;
}

public static void setPicMap(HashMap<String, Object> picMap) {
	CacheData.picMap = picMap;
}
 
}
