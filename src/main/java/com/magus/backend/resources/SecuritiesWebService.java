package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.client.SecuritiesAPIClient;
import com.magus.backend.model.MutualFundDetails;

@Path("/securities")
public class SecuritiesWebService extends AbstractService {

	SecuritiesAPIClient client = new SecuritiesAPIClient();

	@GET
	@Path("/mfDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public MutualFundDetails getMFDetails(@QueryParam("mfSchemeId") String mfSchemeId)
			throws JsonParseException, JsonMappingException, IOException {
		return convertToJSON(client.mutualFundsDetails(mfSchemeId), MutualFundDetails.class);
	}

}
