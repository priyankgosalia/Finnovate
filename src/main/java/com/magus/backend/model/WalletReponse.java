package com.magus.backend.model;

import java.util.ArrayList;
import java.util.List;

public class WalletReponse {

	private String errorCode;
	private String errorDescripttion;
	private List<WalletDetails> WalletDetails = new ArrayList<>();
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescripttion() {
		return errorDescripttion;
	}
	public void setErrorDescripttion(String errorDescripttion) {
		this.errorDescripttion = errorDescripttion;
	}
	public List<WalletDetails> getWalletDetails() {
		return WalletDetails;
	}
	public void setWalletDetails(List<WalletDetails> walletDetails) {
		this.WalletDetails = walletDetails;
	}
	
	
}
