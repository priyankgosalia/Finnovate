package com.magus.backend.model;

import java.util.List;

public class LoanAccountSummary {

	private String errorCode;
	private String errorDescripttion;
	private String success;
	private List<LoanDetails> loanDetails;

	public LoanAccountSummary() {

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

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List<LoanDetails> getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(List<LoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}

}
