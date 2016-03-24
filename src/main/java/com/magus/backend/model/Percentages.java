package com.magus.backend.model;

import java.util.Map;

public class Percentages {

	private Map<String, Double> map;
	private Double total;

	public Map<String, Double> getMap() {
		return map;
	}

	public void setMap(Map<String, Double> map) {
		this.map = map;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Percentages(Double total, Map<String, Double> map) {
		super();
		this.map = map;
		this.total = total;
	}

	public Percentages() {
		super();
	}
	
	
	
}
