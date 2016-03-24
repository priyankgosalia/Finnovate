package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FundsTransfer extends ErrorResponse {

	private String destinationAccountNumber;
	private String transactionDate;
	private String referenceNumber;
	private String transactionAmount;
	private String payeeName;
	private String payeeId;
	private String status;

	public FundsTransfer() {

	}

	public FundsTransfer(String destinationAccountNumber, String transactionDate, String referenceNumber,
			String transactionAmount, String payeeName, String payeeId, String status) {
		super();
		this.destinationAccountNumber = destinationAccountNumber;
		this.transactionDate = transactionDate;
		this.referenceNumber = referenceNumber;
		this.transactionAmount = transactionAmount;
		this.payeeName = payeeName;
		this.payeeId = payeeId;
		this.status = status;
	}

	@JsonProperty("destination_accountno")
	public String getDestinationAccountNumber() {
		return destinationAccountNumber;
	}

	public void setDestinationAccountNumber(String destinationAccountNumber) {
		this.destinationAccountNumber = destinationAccountNumber;
	}

	@JsonProperty("transaction_date")
	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	@JsonProperty("referance_no")
	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@JsonProperty("transaction_amount")
	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@JsonProperty("payee_name")
	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	@JsonProperty("payee_id")
	public String getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
