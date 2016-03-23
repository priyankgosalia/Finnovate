package com.magus.backend.model;

import java.util.List;

public class ShareTransaction {

	private List<ShareTransaction> transactions;
	
	private String from ;
	private String to;
	private Double amount;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public List<ShareTransaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<ShareTransaction> transactions) {
		this.transactions = transactions;
	}
	
	
}
