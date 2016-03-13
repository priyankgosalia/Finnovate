package com.magus.backend.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.APIConstants;

public class CorporateAPIClient extends AbstractClient {

	public CorporateAPIClient() {
		setBASE_URL(APIConstants.CORP_BASE_URL);
	}

	public String accountSummary(String corpid, String userid) {
		Response response = queryClientToken(getWebTarget())
				.path(APIConstants.CORP_ACC_SUMM)
				.queryParam(APIConstants.CORP_ID, corpid)
				.queryParam(APIConstants.USER_ID, userid).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response);
	}

	public String showRM(String corpid, String userid) {
		Response response = queryClientToken(getWebTarget())
				.path(APIConstants.SHOW_RM)
				.queryParam(APIConstants.CORP_ID, corpid)
				.queryParam(APIConstants.USER_ID, userid).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response);
	}

	public String queryRM(String corpid, String userid, String rmid,
			String query) {
		Response response = queryClientToken(getWebTarget())
				.path(APIConstants.SHOW_RM)
				.queryParam(APIConstants.CORP_ID, corpid)
				.queryParam(APIConstants.USER_ID, userid)
				.queryParam(APIConstants.RM_ID, rmid)
				.queryParam(APIConstants.RM_QUERY, query).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getResponse(response);
	}

	public static void main(String[] args) {
		CorporateAPIClient client = new CorporateAPIClient();

		System.out.println(client.accountSummary("13133017",
				"ALEXANDERC- MINIM- OLIVIAM- SEBASTIANC"));
	}
}
