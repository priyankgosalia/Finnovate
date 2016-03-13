package com.magus.backend.model;

public class AccountBalance extends ErrorResponse {

	private Double balance;
	private String accountno;
	private String accounttype;
	private String balancetime;

	public AccountBalance() {

	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getBalancetime() {
		return balancetime;
	}

	public void setBalancetime(String balancetime) {
		this.balancetime = balancetime;
	}
	
}
