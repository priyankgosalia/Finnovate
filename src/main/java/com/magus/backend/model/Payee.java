package com.magus.backend.model;

public class Payee {

	private String creationdate;
	private String payeename;
	private String payeeaccountno;
	private String custid;
	private String payeeid;
	private String shortname;

	public Payee() {

	}

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public String getPayeename() {
		return payeename;
	}

	public void setPayeename(String payeename) {
		this.payeename = payeename;
	}

	public String getPayeeaccountno() {
		return payeeaccountno;
	}

	public void setPayeeaccountno(String payeeaccountno) {
		this.payeeaccountno = payeeaccountno;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPayeeid() {
		return payeeid;
	}

	public void setPayeeid(String payeeid) {
		this.payeeid = payeeid;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

}
