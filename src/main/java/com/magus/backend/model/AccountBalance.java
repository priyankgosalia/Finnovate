package com.magus.backend.model;

import java.util.Date;

public class AccountBalance extends AuthorizationFailed{

	public AccountBalance(Integer code, String description, String message) {
		super(code, description, message);
	}

	private Double balance;
	private String accountNumber;
	private String accountType;
	private Date balanceTime;

	public AccountBalance() {

	}

	public AccountBalance(double balance, String accountNumber, String accountType, Date balanceTime) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balanceTime = balanceTime;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getBalanceTime() {
		return balanceTime;
	}

	public void setBalanceTime(Date balanceTime) {
		this.balanceTime = balanceTime;
	}

}
