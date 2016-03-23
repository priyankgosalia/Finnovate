package com.magus.backend.service;

import java.util.Map;

public class SharingData {
	private Map<String, Double> amountSpent;

	private String message;
	private String personalNotes;

	public String getPersonalNotes() {
		return personalNotes;
	}

	public void setPersonalNotes(String personalNotes) {
		this.personalNotes = personalNotes;
	}

	public SharingData() {}

	public SharingData(Map<String, Double> amountSpent, String message,String personalNotes) {
		super();
		this.amountSpent = amountSpent;
		this.message = message;
		this.personalNotes = personalNotes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Double> getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(Map<String, Double> amountSpent) {
		this.amountSpent = amountSpent;
	}

}