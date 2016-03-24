package com.magus.backend.model;

import java.util.Map;
import java.util.Set;

public class Percentages {

	private Map<String, Double> map;
	private Double total;
	private Set<String> transactionTypes;

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

	
	public Set<String> getTransactionTypes() {
		return transactionTypes;
	}

	public void setTransactionTypes(Set<String> transactionTypes) {
		this.transactionTypes = transactionTypes;
	}

	public Percentages(Double total, Map<String, Double> map) {
		super();
		this.map = map;
		this.total = total;
		this.transactionTypes = this.map.keySet();
	}

	public Percentages() {
		super();
	}
	
	
	
}
