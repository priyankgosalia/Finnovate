package com.magus.backend.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.APIConstants;

public class LoanAPIClient extends AbstractClient {

	public LoanAPIClient() {
		setBASE_URL(APIConstants.LOAN_BASE_URL);
	}

	// Loan Account summary
	public String loanAccountSummaryByAccountNo(String loanAccountNo) {
		Response response = query(getWebTarget()).path(APIConstants.LOAN_ACCOUNT_SUMMARY_STR).path(loanAccountNo)
				.path(APIConstants.CLIENT_ID_VALUE).path(APIConstants.TOKEN_VALUE).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getVanillaResponse(response);
	}

	public String loanAccountSummaryByCustId(String loanAccountNo) {
		Response response = query(getWebTarget()).path(APIConstants.LOAN_ACCOUNT_SUMMARY_STR).path(loanAccountNo)
				.path(APIConstants.CLIENT_ID_VALUE).path(APIConstants.TOKEN_VALUE).request()
				.accept(MediaType.APPLICATION_JSON).get();
		return getVanillaResponse(response);
	}
	
	public static void main(String[] args) {
		LoanAPIClient client = new LoanAPIClient();
		//String accNo = "5555666677770328";
		
		System.out.println(client.loanAccountSummaryByAccountNo("LBMUM11112220001"));
		System.out.println("********************************************************************");
		System.out.println(client.loanAccountSummaryByCustId("88881001"));

		// DummyClient cl2 = new DummyClient();
		// System.out.println(cl2.isKYCDone("999999990019"));
	}
}
