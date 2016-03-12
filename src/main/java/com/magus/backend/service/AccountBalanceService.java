package com.magus.backend.service;

import com.magus.backend.model.AccountBalance;

public class AccountBalanceService {
	
	AccountBalance accountBalance;
	
	public String getBalance(String accountNumber){
		accountBalance.setAccountNumber(accountNumber);
		return accountBalance.toString();
	}
}
