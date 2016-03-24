package com.magus.backend.model;


public class AccountSummary extends ErrorResponse {

	private Double balance;
	private String accountno;
	private String product_desc;
	private String product_type;
	private String sub_product_type;
	private String custid;
	private String accounttype;
	private String account_status;
	private String mobile_no;
	private String product_category;

	public AccountSummary() {

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

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getSub_product_type() {
		return sub_product_type;
	}

	public void setSub_product_type(String sub_product_type) {
		this.sub_product_type = sub_product_type;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}


}
