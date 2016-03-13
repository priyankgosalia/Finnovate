package com.magus.backend.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.APIConstants;

public class InsuranceAPIClient extends AbstractClient {

	public InsuranceAPIClient() {
		setBASE_URL(APIConstants.INSURANCE_BASE_URL);
	}

	public String getCustomerDtls(String mobId, String emailId) {
		Response response = queryClientToken(getWebTarget())
				.path(APIConstants.CUST_DETAILS)
				.queryParam(APIConstants.MOBILE_NO, mobId)
				.queryParam(APIConstants.EMAIL_ID, emailId).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response);
	}

	public String getRenewalNotice(String mobId, String emailId) {
		Response response = queryClientToken(getWebTarget())
				.path(APIConstants.RENEWAL_NOTICE)
				.queryParam(APIConstants.MOBILE_NO, mobId)
				.queryParam(APIConstants.EMAIL_ID, emailId).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response);
	}

	public static void main(String[] args) {
		InsuranceAPIClient client = new InsuranceAPIClient();

		
	}
}
