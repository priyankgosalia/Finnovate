package com.magus.backend.client;

import java.io.IOException;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.model.APIConstants;
import com.magus.backend.model.DummyReponses;

public class RetailAPIClient extends AbstractClient {

	public RetailAPIClient() {
		setBASE_URL(APIConstants.RETAIL_BASE_URL);
	}
	
	//http://retailbanking.mybluemix.net/banking/icicibank/balanceenquiry?client_id=test@abc.com&token=f5316a5e35a4&accountno=9999888877770001
	public String balanceEnquiry(String accNo) {
		WebTarget webTarget = getWebTarget().path(APIConstants.BALANCE_ENQUIRY_STR);
		Response response = queryClientToken(webTarget)
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo)).request()
				.accept(MediaType.APPLICATION_JSON_TYPE).get();
		return getResponse(response, DummyReponses.getRetailBalanceEnq());
		//return getVanillaResponse(response);
	}

	//http://retailbanking.mybluemix.net/banking/icicibank/account_summary?client_id=test@abc.com&token=f5316a5e35a4&custid=88881001&accountno=
	public String accountSummary(String accNo, String custId) {
		Response response = queryClientToken(getWebTarget().path(APIConstants.ACCOUNT_SUMMARY_STR))
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo))
				.queryParam(APIConstants.CUSTID_STR, custId).request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		return getResponse(response, DummyReponses.getRetailAccountSummary());
	}

	public String miniStatement(String accNo){
		Response response = queryClientToken(getWebTarget()).path(APIConstants.TRANSACTION_HISTORY_MINI_STATEMENT_STR)
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo))
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		return "[" + getResponse(response).trim() + "]";
	}
	
	public String transactionHistoryNDays(String accNo, int days){
		queryClientToken(getWebTarget()).path(APIConstants.TRANSACTION_HISTORY_N_DAYS_STR)
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo))
				.queryParam(APIConstants.NUMBER_OF_DAYS, Integer.valueOf(days))
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		return getDummyResponseArray( DummyReponses.getTransactionSummaryNDays());
	}
	
	public String transactionHistoryInterval(String accNo, String fromDate, String toDate) throws JsonParseException, JsonMappingException, IOException {
		Response response = queryClientToken(getWebTarget()).path(APIConstants.TRANSACTION_HISTORY_INTERVAL_STR)
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo))
				.queryParam(APIConstants.FROM_DATE, String.valueOf(fromDate))
				.queryParam(APIConstants.TO_DATE, String.valueOf(toDate))
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		
		String response2 = getResponseArray(response, DummyReponses.getTransactionSummaryInterval());
		return response2;
	}
	
	public String behaviourScore(String accNo) {
		Response response = queryClientToken(getWebTarget()).path(APIConstants.BEHAVIOUR_SCORE_STR)
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo))
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		return getResponse(response, DummyReponses.getBehaviourScore());
	}
	
	public String branchAtmLocator(String lat, String lng){
		Response response = queryClientToken(getWebTarget()).path(APIConstants.BRANCH_ATM_LOCATOR_STR)
				.queryParam(APIConstants.LOCATE_ATM, APIConstants.ATM)
				.queryParam(APIConstants.LATITUDE, lat)
				.queryParam(APIConstants.LONGITUDE, lng)
				.request().accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response);
	}
	
	public String listPayee(String cust_id){
		Response response = queryClientToken(getWebTarget()).path(APIConstants.LIST_PAYEE_STR)
				.queryParam(APIConstants.CUSTID_STR, cust_id)
				.request().accept(MediaType.APPLICATION_JSON).get();
		return "[" + getResponse(response).trim() + "]";
	}
	
	public String transferFunds(String srcAccNo, String destAccNo, double amt, String payeeDesc, int payeeId, String type) {
		Response response = queryClientToken(getWebTarget()).path(APIConstants.FUNDS_TRANSFER_STR)
				.queryParam(APIConstants.SOURCE_ACCOUNT_NUMBER, srcAccNo)
				.queryParam(APIConstants.DESTINATION_ACCOUNT_NUMBER, destAccNo)
				.queryParam(APIConstants.AMOUNT, amt)
				.queryParam(APIConstants.PAYEE_DESC, payeeDesc)
				.queryParam(APIConstants.PAYEE_ID, payeeId)
				.queryParam(APIConstants.TYPE_OF_TRANSACTION, type)
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		return getResponse(response).trim();
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		RetailAPIClient client = new RetailAPIClient();
		String accNo = "5555666677770329";
		String destAccNo = "5555666677779999";
//		System.out.println(client.balanceEnquiry(accNo));
//		System.out.println(client.miniStatement(accNo));
//		System.out.println(client.transactionHistoryNDays(accNo, 10));
//		System.out.println(client.transactionHistoryInterval(accNo, "2016-01-01", "2016-03-31"));
		//System.out.println(client.listPayee("88881328"));
		System.out.println(client.transferFunds(accNo, destAccNo, 10000.00, "A9999", 593, "DTH"));
//		System.out.println(client.miniStatement(destAccNo));
		//System.out.println(client.accountSummary(accNo, "88881328"));
		//System.out.println(client.branchAtmLocator("", ""));

		// DummyClient cl2 = new DummyClient();
		// System.out.println(cl2.isKYCDone("999999990019"));
	}

}
