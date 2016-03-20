package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanTransactionDetails {

	private String last_payments_made;
	private String Payment_mode;

	public LoanTransactionDetails() {

	}

	public String getLast_payments_made() {
		return last_payments_made;
	}

	public void setLast_payments_made(String last_payments_made) {
		this.last_payments_made = last_payments_made;
	}
	@JsonProperty("Payment_mode")
	public String getPayment_mode() {
		return Payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		Payment_mode = payment_mode;
	}

}
