package com.magus.backend.model;

import java.util.HashMap;
import java.util.Map;

import com.magus.backend.service.SharingData;

public class Sharing {

	public Map<String, Double> share(SharingData data) {
		Map<String, Double> map = data.getAmountSpent();
		Map<String, Double> sharing = new HashMap<>();
		Double total = 0.0;
		int noOfShare = map.size();
		for (String mobile : map.keySet()) {
			total += map.get(mobile);
		}
		for (String mobile : map.keySet()) {
			Double thisShare = (total / noOfShare) - map.get(mobile);
			sharing.put(mobile, thisShare);
		}

		return sharing;
	}
}
