package com.magus.backend.model;

public interface APIConstants {

	// public final static String baseURL = "http://localhost:8080/magus/ws/messages";
	public static final String RETAIL_BASE_URL = "https://retailbanking.mybluemix.net/banking/icicibank/";
	public static final String LOAN_BASE_URL = "https://alphaiciapi2.mybluemix.net/rest/Loan/";
	public static final String CORP_BASE_URL = "https://corporate_bank.mybluemix.net/corporate_banking/mybank/";
	public static final String INSURANCE_BASE_URL = "http://generalinsurance.mybluemix.net/banking/icicibank_general_insurance/";
	public static final String POCKET_BASE_URL = "http://alphaiciapi2.mybluemix.net/rest/Wallet/";
	public static final String CLIENT_ID_VALUE = "ujjwal.ju@gmail.com";
	public static final String TOKEN_VALUE = "93bea2128124";

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

	public static final String LOCATE_ATM = "locate";
	public static final String ATM ="ATM";
	public static final String LATITUDE ="lat";
	public static final String LONGITUDE ="long";

	// corporate banking api urls
	public static final String CORP_ACC_SUMM = "corp_account_summary";
	public static final String SHOW_RM = "show_rm_mapping";
	public static final String CORP_ID = "corpid";
	public static final String USER_ID = "userid";
	public static final String RM_QUERY = "corp_rm_query";
	public static final String RM_ID = "rmid";
	public static final String QUERY = "query";

	//insurance api
	public static final String CUST_DETAILS = "getCustomerDtls";
	public static final String MOBILE_NO = "mobileNo";
	public static final String EMAIL_ID = "emailId";
	public static final String RENEWAL_NOTICE = "getRenewalNotice";
	
	//Pockets
	public static final String CREATE_WALLET = "createWallet";
	public static final String CREDIT_WALLET = "creditWalletAmount";
	public static final String DEBIT_WALLET = "debitWalletAmount";
	public static final String BALANCE_WALLET = "getWalletBalance";
	
	// parameter keys
	public static final String ACCOUNT_NUMBER_STR = "accountno";
	public static final String TOKEN_STR = "token";
	public static final String CLIENT_ID_STR = "client_id"; 
	public static final String CUSTID_STR = "custid";
	public static final String NUMBER_OF_DAYS = "days";
	public static final String FROM_DATE = "fromdate";
	public static final String TO_DATE = "todate";
	public static final String MERCHANT = "myMerchant";
}