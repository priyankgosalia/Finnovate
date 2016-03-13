package com.magus.backend.model;

public class LoginResponse {
	private boolean result;
	private String message;
	private int userId;
	private String userFirstName;
	private boolean admin;
	
	public LoginResponse() {
		
	}
	
	public LoginResponse(boolean result, String message, int userId, String userFirstName, boolean admin) {
		super();
		this.result = result;
		this.message = message;
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.admin = admin;
	}
	
	public LoginResponse(boolean result) {
		this.result = result;
		this.message = "";
	}
	
	public LoginResponse(boolean result, String msg) {
		this.result = result;
		this.message = msg;
	}
	
	public static LoginResponse getSuccessResponse() {
		return new LoginResponse(true);
	}
	
	public static LoginResponse getSuccessResponseWithMessage(String msg) {
		return new LoginResponse(true,msg);
	}
	
	public static LoginResponse getFailureResponse() {
		return new LoginResponse(false);
	}
	
	public static LoginResponse getFailureResponseWithMessage(String msg) {
		return new LoginResponse(false,msg);
	}
	
	public boolean isResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
