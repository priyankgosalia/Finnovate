package com.magus.backend.model;

public class RelationManager extends AuthorizationFailed{

	public RelationManager(Integer code, String description, String message) {
		super(code, description, message);
	}

	private Long rm_mobile;
	private String rm_id;
	private String rm_name;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getRm_mobile() {
		return rm_mobile;
	}
	public void setRm_mobile(Long rm_mobile) {
		this.rm_mobile = rm_mobile;
	}
	public String getRm_id() {
		return rm_id;
	}
	public void setRm_id(String rm_id) {
		this.rm_id = rm_id;
	}
	public String getRm_name() {
		return rm_name;
	}
	public void setRm_name(String rm_name) {
		this.rm_name = rm_name;
	}
	public RelationManager(Long rm_mobile, String rm_id, String rm_name) {
		super();
		this.rm_mobile = rm_mobile;
		this.rm_id = rm_id;
		this.rm_name = rm_name;
	}
	
	public RelationManager(String result) {
		super();
		this.result = result;
	}
	

	public RelationManager() {
		super();
	}
}
