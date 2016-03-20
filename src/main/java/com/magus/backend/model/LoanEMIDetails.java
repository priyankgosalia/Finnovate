package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanEMIDetails {

	private String No_of_EMIs;
	private String EMI_Dates;
	private String Last_three_EMIs;

	public LoanEMIDetails() {

	}
	@JsonProperty("No_of_EMIs")
	public String getNo_of_EMIs() {
		return No_of_EMIs;
	}

	public void setNo_of_EMIs(String no_of_EMIs) {
		No_of_EMIs = no_of_EMIs;
	}
	@JsonProperty("EMI_Dates")
	public String getEMI_Dates() {
		return EMI_Dates;
	}

	public void setEMI_Dates(String eMI_Dates) {
		EMI_Dates = eMI_Dates;
	}
	@JsonProperty("Last_three_EMIs")
	public String getLast_three_EMIs() {
		return Last_three_EMIs;
	}

	public void setLast_three_EMIs(String last_three_EMIs) {
		Last_three_EMIs = last_three_EMIs;
	}

}
