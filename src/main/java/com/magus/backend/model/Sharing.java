package com.magus.backend.model;

import java.util.HashMap;
import java.util.Map;

import com.magus.backend.service.SharingData;

public class Sharing {

	public static String share(SharingData data) {
		Map<String, Double> map = data.getAmountSpent();
		Map<String, Double> sharing = new HashMap<>();
		Double total = 0.0;
		int noOfShare = map.size();
		for (String mobile : map.keySet()) {
			total += map.get(mobile);
		}
		//System.out.println("Total :" + total);
		for (String mobile : map.keySet()) {
			Double thisShare = (total / noOfShare) - map.get(mobile);
			sharing.put(mobile, thisShare);
			//System.out.println(mobile + " share : " + thisShare);
		}

		Map<String, Double> stackTake = new HashMap<>();
		Map<String, Double> stackGive = new HashMap<>();
		
		for(String mob :sharing.keySet()){
			Double share = sharing.get(mob);
			if(share < 0){
				stackTake.put(mob, share * -1);
				//System.out.println(mob + " Take : " + (share * -1));
			}
			else{
				stackGive.put(mob, share);
				//System.out.println(mob + " Give : " + share);
			}
		}
		StringBuilder sb = new StringBuilder("{ \"transactions\" : [");
		for(String mob : stackTake.keySet()){
			for(String mob2: stackGive.keySet()){
				Double moneyTransfer = stackGive.get(mob2) < stackTake.get(mob) ? stackGive.get(mob2) : stackTake.get(mob);
				
				String trans = " { \"from\" : \"" + mob2 +"\", \"to\" :\"" + mob + "\", \"amount\": \"" + moneyTransfer + "\"}";
				if(moneyTransfer > 0.0)
				sb.append(trans).append(",");
				stackGive.put(mob2, stackGive.get(mob2) - moneyTransfer);
				stackTake.put(mob, stackTake.get(mob) - moneyTransfer);
				
				//System.out.println(trans);
				//System.out.println(mob2 + " gave, now pending - " + stackGive.get(mob2));
				//System.out.println(mob + " took, now pending - " + stackTake.get(mob));
			}
		}
		
		int lastIndexOfComma = sb.lastIndexOf(",");
		sb = sb.replace(lastIndexOfComma , lastIndexOfComma +1, "").append("] }");
		System.out.println(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SharingData sd = new SharingData();
		Map<String, Double> map = new HashMap<>();
		map.put("a", 1000.0);
		map.put("b", 200.0);
		map.put("c", 400.0);
		map.put("d", 600.0);
		map.put("e", 1600.0);
		map.put("f", 0.0);
		map.put("g", 200.0);
		map.put("h", 600.0);
		sd.setAmountSpent(map);
		
		Sharing.share(sd);
	}
}
