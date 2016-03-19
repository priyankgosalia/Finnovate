package com.magus.backend.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CACHE {
	
	private CACHE() {
	}

	public static Map<String, String> pocketAuthMap;
	
	public static String getFromMap(String mobile){
		if(pocketAuthMap == null){
			pocketAuthMap = new ConcurrentHashMap<>();
			return null;
		}
		return pocketAuthMap.get(mobile);
	}
	
	public static void putInMap(String mobile, String autData){
		if(pocketAuthMap == null){
			pocketAuthMap = new ConcurrentHashMap<>();
		}
		pocketAuthMap.put(mobile, autData);
	}
}
