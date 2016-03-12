package com.magus.backend.model;

import java.util.Date;

public class TransactionHistory {

	private Date transactionDate;
	private String transactionAmount;
	private String closingBalance;
	private String accountNumber;
	private String creditDebitFlag;
	private String remark;

	public TransactionHistory() {

	}

	public TransactionHistory(Date transactionDate, String transactionAmount, String closingBalance,
			String accountNumber, String creditDebitFlag, String remark) {
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.closingBalance = closingBalance;
		this.accountNumber = accountNumber;
		this.creditDebitFlag = creditDebitFlag;
		this.remark = remark;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(String closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCreditDebitFlag() {
		return creditDebitFlag;
	}

	public void setCreditDebitFlag(String creditDebitFlag) {
		this.creditDebitFlag = creditDebitFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
