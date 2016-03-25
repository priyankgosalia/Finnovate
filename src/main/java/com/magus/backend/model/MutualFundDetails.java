package com.magus.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MutualFundDetails extends ErrorResponse {

	private String last_nav_date;
	private String i_sec_research_view;
	private String last_nav;
	private String fund_type;
	private String cut_off_time;
	private String rating;
	private String mf_scheme_id;
	private String AUM;
	private String mf_scheme_name;
	private String fund_mgr_name;
	private String exit_load;

	public MutualFundDetails() {

	}

	public MutualFundDetails(String last_nav_date, String i_sec_research_view, String last_nav, String fund_type,
			String cut_off_time, String rating, String mf_scheme_id, String aUM, String mf_scheme_name,
			String fund_mgr_name, String exit_load) {
		super();
		this.last_nav_date = last_nav_date;
		this.i_sec_research_view = i_sec_research_view;
		this.last_nav = last_nav;
		this.fund_type = fund_type;
		this.cut_off_time = cut_off_time;
		this.rating = rating;
		this.mf_scheme_id = mf_scheme_id;
		AUM = aUM;
		this.mf_scheme_name = mf_scheme_name;
		this.fund_mgr_name = fund_mgr_name;
		this.exit_load = exit_load;
	}

	public String getLast_nav_date() {
		return last_nav_date;
	}

	public void setLast_nav_date(String last_nav_date) {
		this.last_nav_date = last_nav_date;
	}

	public String getI_sec_research_view() {
		return i_sec_research_view;
	}

	public void setI_sec_research_view(String i_sec_research_view) {
		this.i_sec_research_view = i_sec_research_view;
	}

	public String getLast_nav() {
		return last_nav;
	}

	public void setLast_nav(String last_nav) {
		this.last_nav = last_nav;
	}

	public String getFund_type() {
		return fund_type;
	}

	public void setFund_type(String fund_type) {
		this.fund_type = fund_type;
	}

	public String getCut_off_time() {
		return cut_off_time;
	}

	public void setCut_off_time(String cut_off_time) {
		this.cut_off_time = cut_off_time;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getMf_scheme_id() {
		return mf_scheme_id;
	}

	public void setMf_scheme_id(String mf_scheme_id) {
		this.mf_scheme_id = mf_scheme_id;
	}

	@JsonProperty("AUM")
	public String getAUM() {
		return AUM;
	}

	public void setAUM(String aUM) {
		AUM = aUM;
	}

	public String getMf_scheme_name() {
		return mf_scheme_name;
	}

	public void setMf_scheme_name(String mf_scheme_name) {
		this.mf_scheme_name = mf_scheme_name;
	}

	public String getFund_mgr_name() {
		return fund_mgr_name;
	}

	public void setFund_mgr_name(String fund_mgr_name) {
		this.fund_mgr_name = fund_mgr_name;
	}

	public String getExit_load() {
		return exit_load;
	}

	public void setExit_load(String exit_load) {
		this.exit_load = exit_load;
	}

	@Override
	public String toString() {
		return "MutualFundDetails [last_nav_date=" + last_nav_date + ", i_sec_research_view=" + i_sec_research_view
				+ ", last_nav=" + last_nav + ", fund_type=" + fund_type + ", cut_off_time=" + cut_off_time + ", rating="
				+ rating + ", mf_scheme_id=" + mf_scheme_id + ", AUM=" + AUM + ", mf_scheme_name=" + mf_scheme_name
				+ ", fund_mgr_name=" + fund_mgr_name + ", exit_load=" + exit_load + "]";
	}

}
