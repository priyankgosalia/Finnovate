package com.magus.backend.model;

public class AccountSummary {

	private double balance;
	private String accountNumber;
	private String productDescription;
	private String productType;
	private String subProductType;
	private String customerId;
	private String accountType;
	private String accountStatus;
	private String mobileNumber;
	private String productCategory;

	public AccountSummary() {

	}

	public AccountSummary(double balance, String accountNumber, String productDescription, String productType,
			String subProductType, String customerId, String accountType, String accountStatus, String mobileNumber,
			String productCategory) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.productDescription = productDescription;
		this.productType = productType;
		this.subProductType = subProductType;
		this.customerId = customerId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.mobileNumber = mobileNumber;
		this.productCategory = productCategory;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getSubProductType() {
		return subProductType;
	}

	public void setSubProductType(String subProductType) {
		this.subProductType = subProductType;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}
