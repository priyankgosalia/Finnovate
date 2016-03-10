package com.magus.backend.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.C;

public class RetailAPIClient extends AbstractClient {

	public String balanceEnquiry(String accNo) {
		WebTarget webTarget = getWebTarget().path(C.BALANCEENQUIRY_STR);
		Response response = queryClientToken(webTarget)
								.queryParam(C.ACCOUNTNO_STR, String.valueOf(accNo)).request()
								.accept(MediaType.APPLICATION_JSON_TYPE).get();
		String ans = getResponse(response);

		return ans;
	}

	public String accountSummary(String accNo, String custId) {
		Response response = queryClientToken(
				getWebTarget().path(C.ACC_SUMM_STR))
						.queryParam(C.ACCOUNTNO_STR, String.valueOf(accNo))
						.queryParam(C.CUSTID_STR, custId).request()
						.accept(MediaType.APPLICATION_JSON_TYPE).get();
		String ans = getResponse(response);

		return ans;
	}

	public static void main(String[] args) {
		RetailAPIClient client = new RetailAPIClient();
		String accNo = "5555666677770328";
		System.out.println(client.balanceEnquiry(accNo));
		System.out.println(client.accountSummary(accNo, "88881328"));
		
		DummyClient cl2 = new DummyClient();
		System.out.println(cl2.isKYCDone("999999990019"));
	}
}
