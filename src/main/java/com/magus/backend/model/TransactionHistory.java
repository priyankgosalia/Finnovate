package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionHistory extends ErrorResponse {

	private String transactiondate;
	private String amount;
	private String closing_balance;
	private String accountno;
	private String credit_debit_flag;
	private String remark;

	public TransactionHistory() {

	}

	@JsonProperty("transactiondate")
	public String getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	@JsonProperty("transaction_amount")
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@JsonProperty("closing_balance")
	public String getClosing_balance() {
		return closing_balance;
	}

	public void setClosing_balance(String closing_balance) {
		this.closing_balance = closing_balance;
	}

	@JsonProperty("accountno")
	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getCredit_debit_flag() {
		return credit_debit_flag;
	}

	public void setCredit_debit_flag(String credit_debit_flag) {
		this.credit_debit_flag = credit_debit_flag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
