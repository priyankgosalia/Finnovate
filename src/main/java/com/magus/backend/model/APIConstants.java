package com.magus.backend.model;

public interface APIConstants {

	// public final static String baseURL = "http://localhost:8080/magus/ws/messages";
	public static final String RETAIL_BASE_URL = "https://retailbanking.mybluemix.net/banking/icicibank/";
	public static final String LOAN_BASE_URL = "https://alphaiciapi2.mybluemix.net/rest/Loan/";
	public static final String CLIENT_ID_VALUE = "ujjwal.ju@gmail.com";
	public static final String TOKEN_VALUE = "0d78405d6ac4";

	// retail banking api urls
	public static final String BALANCE_ENQUIRY_STR = "balanceenquiry";
	public static final String ACCOUNT_SUMMARY_STR = "account_summary";
	public static final String TRANSACTION_HISTORY_MINI_STATEMENT_STR = "recenttransaction";
	public static final String TRANSACTION_HISTORY_N_DAYS_STR = "ndaystransaction";
	public static final String TRANSACTION_HISTORY_INTERVAL_STR = "transactioninterval";
	public static final String BEHAVIOUR_SCORE_STR = "behaviour_score";
	public static final String LIST_PAYEE_STR = "listpayee";
	public static final String FUNDS_TRANSFER_STR = "fundsTransfer";
	public static final String BRANCH_ATM_LOCATOR_STR = "BranchAtmLocator";
	public static final String LOAN_ACCOUNT_SUMMARY_STR = "getLoanDetails";
	public static final String LOAN_CUSTOMER_DETAILS_STR = "customerDetails";
	public static final String LOAN_EMI_DETAILS_STR = "EMIDetails";
	public static final String LOAN_TRANSACTION_DETAILS_STR = "transDetails";
	public static final String CARD_ACCOUNT_DETAILS_STR = "getCardDetails";

	// corporate banking api urls
	
	// parameter keys
	public static final String ACCOUNT_NUMBER_STR = "accountno";
	public static final String TOKEN_STR = "token";
	public static final String CLIENT_ID_STR = "client_id"; 
	public static final String CUSTID_STR = "custid";

}