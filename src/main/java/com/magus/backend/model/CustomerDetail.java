package com.magus.backend.model;


public class CustomerDetail extends ErrorResponse {

	public CustomerDetail(Integer code, String description, String message) {
		super(code, description, message);
	}

	private String pincode;
	private String email_id;
	private String total_premium_amt;
	private String product;
	private String insured_name;
	private String policy_end_date;
	private String resident_add;
	private String policy_start_date;
	private String mobile_no;

	public CustomerDetail() {

	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getTotal_premium_amt() {
		return total_premium_amt;
	}

	public void setTotal_premium_amt(String total_premium_amt) {
		this.total_premium_amt = total_premium_amt;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getInsured_name() {
		return insured_name;
	}

	public void setInsured_name(String insured_name) {
		this.insured_name = insured_name;
	}

	public String getPolicy_end_date() {
		return policy_end_date;
	}

	public void setPolicy_end_date(String policy_end_date) {
		this.policy_end_date = policy_end_date;
	}

	public String getResident_add() {
		return resident_add;
	}

	public void setResident_add(String resident_add) {
		this.resident_add = resident_add;
	}

	public String getPolicy_start_date() {
		return policy_start_date;
	}

	public void setPolicy_start_date(String policy_start_date) {
		this.policy_start_date = policy_start_date;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public CustomerDetail(String pincode, String email_id, String total_premium_amt,
			String product, String insured_name, String policy_end_date,
			String resident_add, String policy_start_date, String mobile_no) {
		super();
		this.pincode = pincode;
		this.email_id = email_id;
		this.total_premium_amt = total_premium_amt;
		this.product = product;
		this.insured_name = insured_name;
		this.policy_end_date = policy_end_date;
		this.resident_add = resident_add;
		this.policy_start_date = policy_start_date;
		this.mobile_no = mobile_no;
	}

	
}
