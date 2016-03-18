package com.magus.backend.model;

public class PocketCreditResp {

	private String txn_id;
	private String amount;
	private String bank_txn_id ;
	private String errorCode ;
	private String errorDescripttion;
	public String getTxn_id() {
		return txn_id;
	}
	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBank_txn_id() {
		return bank_txn_id;
	}
	public void setBank_txn_id(String bank_txn_id) {
		this.bank_txn_id = bank_txn_id;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescripttion() {
		return errorDescripttion;
	}
	public void setErrorDescripttion(String errorDescripttion) {
		this.errorDescripttion = errorDescripttion;
	}
	public PocketCreditResp(String txn_id, String amount, String bank_txn_id,
			String errorCode, String errorDescripttion) {
		super();
		this.txn_id = txn_id;
		this.amount = amount;
		this.bank_txn_id = bank_txn_id;
		this.errorCode = errorCode;
		this.errorDescripttion = errorDescripttion;
	}
	public PocketCreditResp() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
