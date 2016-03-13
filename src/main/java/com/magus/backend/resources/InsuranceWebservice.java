package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.client.InsuranceAPIClient;
import com.magus.backend.model.CustomerDetail;
import com.magus.backend.model.PolicyRenewal;

@Path("/insurance")
public class InsuranceWebservice extends AbstractService {

	InsuranceAPIClient client = new InsuranceAPIClient();
	
	@GET
	@Path("/getCustomerDtls")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerDetail getCorpAccSumm(@QueryParam ("mobileNo") String mobileNo, @QueryParam("emailId") String emailId) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.getCustomerDtls(mobileNo, emailId), CustomerDetail.class);
	}
	
	@GET
	@Path("/getRenewalNotice")
	@Produces(MediaType.APPLICATION_JSON)
	public PolicyRenewal getRenewalNotice(@QueryParam ("mobileNo") String mobileNo, @QueryParam("emailId") String emailId) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.getCustomerDtls(mobileNo, emailId), PolicyRenewal.class);
	}

}

