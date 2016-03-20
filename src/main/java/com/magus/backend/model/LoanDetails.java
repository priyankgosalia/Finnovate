package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanDetails {
	
	private String ID;
	private String loanAccounNo;
	private String customerName;
	private String pos;
	private String principal_outstanding;
	private String date_of_loan;
	private String type_of_loan;
	private String roi;
	private String month_delinquency;
	private double loanAmount;
	private String custId;

	public LoanDetails() {

	}

	@JsonProperty("ID")
	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getLoanAccounNo() {
		return loanAccounNo;
	}

	public void setLoanAccounNo(String loanAccounNo) {
		this.loanAccounNo = loanAccounNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getPrincipal_outstanding() {
		return principal_outstanding;
	}

	public void setPrincipal_outstanding(String principal_outstanding) {
		this.principal_outstanding = principal_outstanding;
	}

	public String getDate_of_loan() {
		return date_of_loan;
	}

	public void setDate_of_loan(String date_of_loan) {
		this.date_of_loan = date_of_loan;
	}

	public String getType_of_loan() {
		return type_of_loan;
	}

	public void setType_of_loan(String type_of_loan) {
		this.type_of_loan = type_of_loan;
	}

	public String getRoi() {
		return roi;
	}

	public void setRoi(String roi) {
		this.roi = roi;
	}

	public String getMonth_delinquency() {
		return month_delinquency;
	}

	public void setMonth_delinquency(String month_delinquency) {
		this.month_delinquency = month_delinquency;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}
