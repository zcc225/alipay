package com.zccpro;

import java.util.HashMap;

import com.zccpro.test.CacheData;

public class CacheTestpush {

	public static void main(String[] args) {
		HashMap<String,Object> picMap = CacheData.getPicMap();
		picMap.put("aa", "aaaaaaa");
	}
}
