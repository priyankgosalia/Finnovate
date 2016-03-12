package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magus.backend.client.RetailAPIClient;
import com.magus.backend.model.AccountBalance;
import com.magus.backend.model.AccountSummary;
import com.magus.backend.model.BranchAtmLocator;

@Path("/retail")
public class RetailWebservice {

	RetailAPIClient client = new RetailAPIClient();
	
	@GET
	@Path("/accountSummary")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountSummary getMessages(@QueryParam ("accountNumber") String accNo, @QueryParam("customerId") String custId) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(client.accountSummary(accNo, custId), AccountSummary.class);
	}
	
	@GET
	@Path("/balance")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountBalance getAccountBalance(@QueryParam("accountNumber") String accNo) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(client.balanceEnquiry(accNo), AccountBalance.class);
	}
	
	@GET
	@Path("/atmLocator")
	@Produces(MediaType.APPLICATION_JSON)
	public BranchAtmLocator getAtmLocator(@QueryParam("lat") String latitude, @QueryParam("long") String longitude) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(client.branchAtmLocator(latitude, longitude), BranchAtmLocator.class);
	}
}
