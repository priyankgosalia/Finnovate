package com.magus.backend.model;

import java.util.Date;

public class AccountBalance {

	private double balance;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
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
