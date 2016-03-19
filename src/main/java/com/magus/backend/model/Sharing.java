package com.magus.backend.model;

import java.util.HashMap;
import java.util.Map;

import com.magus.backend.service.SharingData;

public class Sharing {


	public Map<String, Double> share(SharingData data ){
		Map<String, Double> map = data.getShareRatio();
		Map<String, Double> sharing = new HashMap<>();
		for(String mobile : map.keySet()){
			Double thisShare = data.getBillAmount()*map.get(mobile);
			sharing.put(mobile, thisShare);
		}
		
		return sharing;
	}
}
