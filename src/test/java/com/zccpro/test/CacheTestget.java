package com.zccpro.test;

import java.util.HashMap;

public class CacheTestget {
public static void main(String[] args) {
	CacheData cacheData = new CacheData();
	HashMap<String,Object> picMap = CacheData.getPicMap();
	Object object = picMap.get("aa");
}
}
