package com.magus.backend.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.APIConstants;

public class RetailAPIClient extends AbstractClient {

	//http://retailbanking.mybluemix.net/banking/icicibank/balanceenquiry?client_id=test@abc.com&token=f5316a5e35a4&accountno=9999888877770001
	public String balanceEnquiry(String accNo) {
		WebTarget webTarget = getWebTarget().path(APIConstants.BALANCE_ENQUIRY_STR);
		Response response = queryClientToken(webTarget)
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo)).request()
				.accept(MediaType.APPLICATION_JSON_TYPE).get();
		String ans = getResponse(response);

		return ans;
	}

	//http://retailbanking.mybluemix.net/banking/icicibank/account_summary?client_id=test@abc.com&token=f5316a5e35a4&custid=88881001&accountno=
	public String accountSummary(String accNo, String custId) {
		Response response = queryClientToken(getWebTarget().path(APIConstants.ACCOUNT_SUMMARY_STR))
				.queryParam(APIConstants.ACCOUNT_NUMBER_STR, String.valueOf(accNo))
				.queryParam(APIConstants.CUSTID_STR, custId).request().accept(MediaType.APPLICATION_JSON_TYPE).get();
		String ans = getResponse(response);

		return ans;
	}

	public static void main(String[] args) {
		RetailAPIClient client = new RetailAPIClient();
		String accNo = "5555666677770328";
		System.out.println(client.balanceEnquiry(accNo));
		System.out.println(client.accountSummary(accNo, "88881328"));

		// DummyClient cl2 = new DummyClient();
		// System.out.println(cl2.isKYCDone("999999990019"));
	}
}
