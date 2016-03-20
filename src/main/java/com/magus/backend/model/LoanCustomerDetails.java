package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanCustomerDetails {

	private String Name;
	private String Dob;
	private String No_of_depenants;
	private String Salary_details;

	public LoanCustomerDetails() {

	}
	@JsonProperty("Name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	@JsonProperty("Dob")
	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}
	@JsonProperty("No_of_depenants")
	public String getNo_of_depenants() {
		return No_of_depenants;
	}

	public void setNo_of_depenants(String no_of_depenants) {
		No_of_depenants = no_of_depenants;
	}
	@JsonProperty("Salary_details")
	public String getSalary_details() {
		return Salary_details;
	}

	public void setSalary_details(String salary_details) {
		Salary_details = salary_details;
	}

}