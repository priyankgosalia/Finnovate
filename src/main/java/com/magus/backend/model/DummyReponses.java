package com.magus.backend.model;

public class DummyReponses {

	public static String getRetailBalanceEnq(){
		return "[{ \"code\":200}, { \"balance\":5000000.00, \"accountno\":\"9999888877770001\", \"accounttype\":\"Savings Account\", \"balancetime\":\"01-02-16 14:43:259 IST\" }]";
	}
	
	public static String getRetailAccountSummary(){
		return "[{ \"code\":200 }, { \"accountno\": \"9999888877770001\", \"balance\": \"5000000.00\", \"product_desc\": \"Regular Savings Account\", \"product_type\": \"Savings Account\", \"sub_product_type\": \"Regular Savings Account\", \"custid\": \"99999901\", \"accounttype\": \"Savings Account\", \"account_status\": \"Active\", \"mobile_no\": \"4444411111\", \"product_category\": \"Liabilities\" }]";
	}
	
	public static String getMiniStatementSummary(){
		return "{\"code\":200}, {\"transactiondate\":\"2016-03-21 22:16:24.0\",\"closing_balance\":\"4997386.770\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"285.00\",\"remark\":\"DTH\"}, {\"transactiondate\":\"2016-03-21 21:05:50.0\",\"closing_balance\":\"4997671.770\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"328.230\",\"remark\":\"Electricity\"}, {\"transactiondate\":\"2016-03-21 21:05:15.0\",\"closing_balance\":\"4998000.00\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"1000.00\",\"remark\":\"PMR\"}, {\"transactiondate\":\"2016-03-21 20:56:44.0\",\"closing_balance\":\"4999000.00\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"1000.00\",\"remark\":\"DTH\"}";
	}
	
	public static String getTransactionSummaryNDays(){
		return "{\"code\":200}, {\"transactiondate\":\"2016-03-21 22:16:24.0\",\"closing_balance\":\"4997386.770\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"285.00\",\"remark\":\"DTH\"}, {\"transactiondate\":\"2016-03-21 21:05:50.0\",\"closing_balance\":\"4997671.770\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"328.230\",\"remark\":\"Electricity\"}, {\"transactiondate\":\"2016-03-21 21:05:15.0\",\"closing_balance\":\"4998000.00\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"1000.00\",\"remark\":\"PMR\"}, {\"transactiondate\":\"2016-03-21 20:56:44.0\",\"closing_balance\":\"4999000.00\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"1000.00\",\"remark\":\"DTH\"}";
	}

	public static String getTransactionSummaryInterval() {
		return "{\"code\":200}, {\"transactiondate\":\"2016-03-21 22:16:24.0\",\"closing_balance\":\"4997386.770\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"285.00\",\"remark\":\"DTH\"}, {\"transactiondate\":\"2016-03-21 21:05:50.0\",\"closing_balance\":\"4997671.770\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"328.230\",\"remark\":\"Electricity\"}, {\"transactiondate\":\"2016-03-21 21:05:15.0\",\"closing_balance\":\"4998000.00\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"1000.00\",\"remark\":\"PMR\"}, {\"transactiondate\":\"2016-03-21 20:56:44.0\",\"closing_balance\":\"4999000.00\",\"accountno\":\"5555666677770329\",\"credit_debit_flag\":\"Dr.\",\"transaction_amount\":\"1000.00\",\"remark\":\"DTH\"}";
	}
	
	public static String getBehaviourScore() {
		return "[{ \"code\":200 }, { \"score\": 80}]";
	}

	public static String getPocketCreation(){
		return "{\"errorCode\":\"200\",\"errorDescripttion\":\"success\",\"walletDetails\":[{\"creationStatus\":\"Wallet Already Exist\",\"auth_data\":\"1fa0b37aa7524640a247\"}]}";
	}

	public static String getPocketCredit(Double amount){
		return "{\"amount\":"+ amount +", \"txn_id\":\"123498\", \"bank_txn_id\":\"80527\", \"errorCode\":\"200\", \"errorDescripttion\":\"success\" } ";
	}

	public static String getPocketDebit(Double amount){
		return "{\"amount\":"+ amount +", \"txn_id\":\"123498\", \"bank_txn_id\":\"80527\", \"errorCode\":\"200\", \"errorDescripttion\":\"success\" } ";
	}

}
