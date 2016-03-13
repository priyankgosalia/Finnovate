package com.magus.backend.model;

public class OTPResponse {
	private String OTP;
	
	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public OTPResponse() {
		
	}
	
	public OTPResponse(String otp) {
		this.OTP = otp;
	}
}
