package com.magus.backend.model;

public class KYCResponse {
	private boolean result;
	private String message;
	
	public KYCResponse() {
		
	}
	
	public KYCResponse(boolean result, String msg) {
		this.result = result;
		this.message = msg;
	}
	
	public KYCResponse(boolean result) {
		this.result = result;
		this.message = "";
	}
	
	public static KYCResponse getSuccessResponse() {
		return new KYCResponse(true);
	}
	
	public static KYCResponse getSuccessResponseWithMessage(String msg) {
		return new KYCResponse(true,msg);
	}
	
	public static KYCResponse getFailureResponse() {
		return new KYCResponse(false);
	}
	
	public static KYCResponse getFailureResponseWithMessage(String msg) {
		return new KYCResponse(false,msg);
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
	
}
