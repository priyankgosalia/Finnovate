package com.magus.backend.model;


public class PolicyRenewal extends ErrorResponse {

	public PolicyRenewal(Integer code, String description, String message) {
		super(code, description, message);
	}

	private String email_id;
	private String mobile_no;
	private String policy_no;

	private String rto;
	private String manufacturer;
	private String new_policy_no;
	private String policy_end_date;
	private Double serv_tax;
	private String policy_st_date;
	private String engine_no;
	private String chasis_no;
	private String model;
	private String custname;
	private String idv;
	private String vechile_tp;
	private String tot_premium_amt;

	public PolicyRenewal() {	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getRto() {
		return rto;
	}

	public void setRto(String rto) {
		this.rto = rto;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getNew_policy_no() {
		return new_policy_no;
	}

	public void setNew_policy_no(String new_policy_no) {
		this.new_policy_no = new_policy_no;
	}

	public String getPolicy_end_date() {
		return policy_end_date;
	}

	public void setPolicy_end_date(String policy_end_date) {
		this.policy_end_date = policy_end_date;
	}

	public Double getServ_tax() {
		return serv_tax;
	}

	public void setServ_tax(Double serv_tax) {
		this.serv_tax = serv_tax;
	}

	public String getPolicy_st_date() {
		return policy_st_date;
	}

	public void setPolicy_st_date(String policy_st_date) {
		this.policy_st_date = policy_st_date;
	}

	public String getEngine_no() {
		return engine_no;
	}

	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}

	public String getChasis_no() {
		return chasis_no;
	}

	public void setChasis_no(String chasis_no) {
		this.chasis_no = chasis_no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getIdv() {
		return idv;
	}

	public void setIdv(String idv) {
		this.idv = idv;
	}

	public String getVechile_tp() {
		return vechile_tp;
	}

	public void setVechile_tp(String vechile_tp) {
		this.vechile_tp = vechile_tp;
	}

	public String getTot_premium_amt() {
		return tot_premium_amt;
	}

	public void setTot_premium_amt(String tot_premium_amt) {
		this.tot_premium_amt = tot_premium_amt;
	}

	public PolicyRenewal(String email_id, String mobile_no, String policy_no,
			String rto, String manufacturer, String new_policy_no,
			String policy_end_date, Double serv_tax, String policy_st_date,
			String engine_no, String chasis_no, String model, String custname,
			String idv, String vechile_tp, String tot_premium_amt) {
		super();
		this.email_id = email_id;
		this.mobile_no = mobile_no;
		this.policy_no = policy_no;
		this.rto = rto;
		this.manufacturer = manufacturer;
		this.new_policy_no = new_policy_no;
		this.policy_end_date = policy_end_date;
		this.serv_tax = serv_tax;
		this.policy_st_date = policy_st_date;
		this.engine_no = engine_no;
		this.chasis_no = chasis_no;
		this.model = model;
		this.custname = custname;
		this.idv = idv;
		this.vechile_tp = vechile_tp;
		this.tot_premium_amt = tot_premium_amt;
	}
	
	
}
