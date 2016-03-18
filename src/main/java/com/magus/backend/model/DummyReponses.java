package com.magus.backend.model;

public class DummyReponses {

	public static String getRetailBalanceEnq(){
		return "[{ \"code\":200}, { \"balance\":5000000.00, \"accountno\":\"9999888877770001\", \"accounttype\":\"Savings Account\", \"balancetime\":\"01-02-16 14:43:259 IST\" }]";
	}
	
	public static String getRetailAccountSummary(){
		return "[{ \"code\":200 }, { \"accountno\": \"9999888877770001\", \"balance\": \"5000000.00\", \"product_desc\": \"Regular Savings Account\", \"product_type\": \"Savings Account\", \"sub_product_type\": \"Regular Savings Account\", \"custid\": \"99999901\", \"accounttype\": \"Savings Account\", \"account_status\": \"Active\", \"mobile_no\": \"4444411111\", \"product_category\": \"Liabilities\" }]";
	}
	
	public static String getMiniStatementSummary(){
		return "[{ \"code\":200 }, { \"accountno\": \"9999888877770001\", \"closing_balance\": \"5000000.00\", \"transactiondate\": \"2016-02-09 12:14:33.000 IST\", \"amount\": \"10000.00\", \"credit_debit_flag\": \"Dr.\", \"remark\": \"My Remark\"}]";
	}
	
	public static String getTransactionSummaryNDays(){
		return "[{ \"code\":200 }, { \"accountno\": \"9999888877770001\", \"closing_balance\": \"5000000.00\", \"transactiondate\": \"2016-02-09 12:14:33.000 IST\", \"amount\": \"10000.00\", \"credit_debit_flag\": \"Dr.\", \"remark\": \"My Remark\"}]";
	}

	public static String getTransactionSummaryInterval() {
		return "[{ \"code\":200 }, { \"accountno\": \"9999888877770001\", \"closing_balance\": \"5000000.00\", \"transactiondate\": \"2016-02-09 12:14:33.000 IST\", \"amount\": \"10000.00\", \"credit_debit_flag\": \"Dr.\", \"remark\": \"My Remark\"}]";
	}
	
	public static String getBehaviourScore() {
		return "[{ \"code\":200 }, { \"score\": 80}]";
	}

	public static String getPocketCreation(){
		return "{\"errorCode\":\"200\",\"errorDescripttion\":\"success\",\"walletDetails\":[{\"creationStatus\":\"Wallet Already Exist\",\"auth_data\":\"a6af52c1154d4a5496e1\"}]}";
	}

	public static String getPocketCredit(String amount){
		return "{\"amount\":"+ amount +", \"txn_id\":\"123498\", \"bank_txn_id\":\"80527\", \"errorCode\":\"200\", \"errorDescripttion\":\"success\" } ";
	}

}
