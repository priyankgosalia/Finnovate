package com.magus.backend.model;

import com.magus.backend.model.ErrorResponse;

public class CorpAccountSummary extends ErrorResponse {

	public CorpAccountSummary(Integer code, String description, String message) {
		super(code, description, message);
	}

	private Double balance;
	private String account_no;
	private String currency;
	private String account_status;

	public CorpAccountSummary() {

	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public CorpAccountSummary(String code, String description, String message, Double balance, String account_no,
			String currency, String account_status) {
		super();
		this.balance = balance;
		this.account_no = account_no;
		this.currency = currency;
		this.account_status = account_status;
	}

}
