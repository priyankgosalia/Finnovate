package com.magus.backend.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.APIConstants;

public class SecuritiesAPIClient extends AbstractClient {

	public SecuritiesAPIClient() {
		setBASE_URL(APIConstants.SECURITIES_BASE_URL);
	}

	public String mutualFundsDetails(String mfSchemeId) {
		Response response = queryClientToken(getWebTarget()).path(APIConstants.GET_MUTUAL_FUND_DETAILS)
				.queryParam(APIConstants.MF_SCHEME_ID, mfSchemeId).request().accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response).trim();
	}
	
	public static void main(String[] args) {
		SecuritiesAPIClient client = new SecuritiesAPIClient();
		System.out.println(client.mutualFundsDetails("10001"));
	}
}
