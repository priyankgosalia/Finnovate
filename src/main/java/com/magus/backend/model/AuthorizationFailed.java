package com.magus.backend.model;

public class AuthorizationFailed {

	private Integer code;
	private String description;
	private String message;

	
	public AuthorizationFailed(Integer code, String description, String message) {
		super();
		this.code = code;
		this.description = description;
		this.message = message;
	}

	public AuthorizationFailed() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}