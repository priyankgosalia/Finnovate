package com.magus.backend.model;

public class AuthorizationFailed {

	private String code;
	private String description;
	private String message;

	
	public AuthorizationFailed(String code, String description, String message) {
		super();
		this.code = code;
		this.description = description;
		this.message = message;
	}

	public AuthorizationFailed() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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