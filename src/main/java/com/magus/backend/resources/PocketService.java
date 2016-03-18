package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.client.PocketAPIClient;
import com.magus.backend.model.PocketCreditResp;
import com.magus.backend.model.WalletProfile;
import com.magus.backend.model.WalletReponse;

@Path("/pocket")
public class PocketService  extends AbstractService {
	
	PocketAPIClient client = new PocketAPIClient();
	private static final Logger logger = LogManager.getLogger(PocketService.class.getName());
	
	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public WalletReponse create(@QueryParam("firstName") String firstName,@QueryParam("lastName") String lastName,@QueryParam("emailId") String emailId,@QueryParam("mobile") String  mobile,@QueryParam("birthDate") String birthDate,@QueryParam("gender") String gender,@QueryParam("ipConfig") String ipConfig,@QueryParam("platform") String  platform,@QueryParam("deviceId") String deviceId,@QueryParam("state") String state) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("Received Following create request: "+ firstName + " : " + lastName + " : " + emailId + " : " + mobile + " : " + birthDate + " : " + gender + " : " + ipConfig + " : " + platform + " : " + deviceId + " : " + state);
		WalletProfile wallet = new WalletProfile(firstName, lastName, emailId, mobile, birthDate, gender, ipConfig, platform, deviceId, state);
		return convertToJSON(client.create(wallet), WalletReponse.class);	
	}

	@GET
	@Path("/credit")
	@Produces(MediaType.APPLICATION_JSON)
	public PocketCreditResp credit(@QueryParam("amount") String amount) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.credit(amount), PocketCreditResp.class);
	}
}
