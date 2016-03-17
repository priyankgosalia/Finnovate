package com.magus.backend.service;

import java.util.Map;

public class SharingData {
	private Integer noOfShares;
	private Double billAmount;
	private Map<String, Double> shareRatio;
	private String message;
	private String personalNotes;

	public String getPersonalNotes() {
		return personalNotes;
	}

	public void setPersonalNotes(String personalNotes) {
		this.personalNotes = personalNotes;
	}

	public SharingData() {
	}

	public SharingData(Integer noOfShares, Double billAmount,
			Map<String, Double> shareRatio, String message,String personalNotes) {
		super();
		this.noOfShares = noOfShares;
		this.billAmount = billAmount;
		this.shareRatio = shareRatio;
		this.message = message;
		this.personalNotes = personalNotes;
	}

	public Integer getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(Integer noOfShares) {
		this.noOfShares = noOfShares;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public Map<String, Double> getShareRatio() {
		return shareRatio;
	}

	public void setShareRatio(Map<String, Double> shareRatio) {
		this.shareRatio = shareRatio;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}