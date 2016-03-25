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
import com.magus.backend.cache.CACHE;
import com.magus.backend.client.PocketAPIClient;
import com.magus.backend.model.PocketCreditResp;
import com.magus.backend.model.PocketPost;
import com.magus.backend.model.WalletProfile;
import com.magus.backend.model.WalletReponse;

@Path("/pocket")
public class PocketService extends AbstractService {

	PocketAPIClient client = new PocketAPIClient();
	private static final Logger logger = LogManager.getLogger(PocketService.class.getName());

	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public WalletReponse create(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName,
			@QueryParam("emailId") String emailId, @QueryParam("mobile") String mobile,
			@QueryParam("birthDate") String birthDate, @QueryParam("gender") String gender,
			@QueryParam("ipConfig") String ipConfig, @QueryParam("platform") String platform,
			@QueryParam("deviceId") String deviceId, @QueryParam("state") String state)
					throws JsonParseException, JsonMappingException, IOException {
		logger.info("Received Following create request: " + firstName + " : " + lastName + " : " + emailId + " : "
				+ mobile + " : " + birthDate + " : " + gender + " : " + ipConfig + " : " + platform + " : " + deviceId
				+ " : " + state);
		WalletProfile wallet = new WalletProfile(firstName, lastName, emailId, mobile, birthDate, gender, ipConfig,
				platform, deviceId, state);
		WalletReponse response = convertToJSON(client.create(wallet), WalletReponse.class);
		System.out.println(response);
		CACHE.putInMap(mobile, response.getWalletDetails().get(0).getAuth_data());

		return response;
	}

	@GET
	@Path("/credit")
	@Produces(MediaType.APPLICATION_JSON)
	public PocketCreditResp credit(@QueryParam("amount") Double amount, @QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("emailId") String emailId,
			@QueryParam("mobile") String mobile, @QueryParam("birthDate") String birthDate,
			@QueryParam("gender") String gender, @QueryParam("ipConfig") String ipConfig,
			@QueryParam("platform") String platform, @QueryParam("deviceId") String deviceId,
			@QueryParam("state") String state) throws JsonParseException, JsonMappingException, IOException {
		String auth_data = getAuthData(firstName, lastName, emailId, mobile, birthDate, gender, ipConfig, platform,
				deviceId, state);
		// String auth_data = "0dfa125fed634134b275";
		String imei = "35550702720000";

		PocketPost creditRequest = new PocketPost();
		creditRequest.setId_type("TOKEN");
		creditRequest.setId_value("abcVxAfkBTN7t3jjnrdw");
		creditRequest.setAuth_type("TOKEN");
		creditRequest.setAuth_data(auth_data);
		creditRequest.setTxn_id("123498");
		creditRequest.setAmount(amount);
		creditRequest.setPromocode("pockt1234");
		creditRequest.setRemarks("Cake Shopp");
		creditRequest.setSub_merchant("Cakerina");
		creditRequest.setLatitude("19.11376955");
		creditRequest.setLongitude("73.8500124");
		creditRequest.setImei(imei);
		creditRequest.setIp_address("194.154.205.26");
		creditRequest.setOs("android");

		return convertToJSON(client.credit(creditRequest), PocketCreditResp.class);
	}

	@GET
	@Path("/debit")
	@Produces(MediaType.APPLICATION_JSON)
	public PocketCreditResp debit(@QueryParam("amount") Double amount, @QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName, @QueryParam("emailId") String emailId,
			@QueryParam("mobile") String mobile, @QueryParam("birthDate") String birthDate,
			@QueryParam("gender") String gender, @QueryParam("ipConfig") String ipConfig,
			@QueryParam("platform") String platform, @QueryParam("deviceId") String deviceId,
			@QueryParam("state") String state) throws JsonParseException, JsonMappingException, IOException {
		String auth_data = getAuthData(firstName, lastName, emailId, mobile, birthDate, gender, ipConfig, platform,
				deviceId, state);
		// String auth_data = "0dfa125fed634134b275";
		String imei = "35550702720000";

		PocketPost creditRequest = new PocketPost();
		creditRequest.setId_type("TOKEN");
		creditRequest.setId_value("abcVxAfkBTN7t3jjnrdw");
		creditRequest.setAuth_type("TOKEN");
		creditRequest.setAuth_data(auth_data);
		creditRequest.setTxn_id("123498");
		creditRequest.setAmount(amount);
		creditRequest.setPromocode("pockt1234");
		creditRequest.setRemarks("Cake Shopp");
		creditRequest.setSub_merchant("Cakerina");
		creditRequest.setLatitude("19.11376955");
		creditRequest.setLongitude("73.8500124");
		creditRequest.setImei(imei);
		creditRequest.setIp_address("194.154.205.26");
		creditRequest.setOs("android");

		return convertToJSON(client.debit(creditRequest), PocketCreditResp.class);
	}

	private String getAuthData(String firstName, String lastName, String emailId, String mobile, String birthDate,
			String gender, String ipConfig, String platform, String deviceId, String state)
					throws JsonParseException, JsonMappingException, IOException {
		String auth_data = CACHE.getFromMap(mobile);
		if (auth_data == null) {
			logger.info("Received Following create request: " + firstName + " : " + lastName + " : " + emailId + " : "
					+ mobile + " : " + birthDate + " : " + gender + " : " + ipConfig + " : " + platform + " : "
					+ deviceId + " : " + state);
			WalletProfile wallet = new WalletProfile(firstName, lastName, emailId, mobile, birthDate, gender, ipConfig,
					platform, deviceId, state);
			WalletReponse response = convertToJSON(client.create(wallet), WalletReponse.class);
			System.out.println(response);
			CACHE.putInMap(mobile, response.getWalletDetails().get(0).getAuth_data());
			auth_data = CACHE.getFromMap(mobile);
		}
		return auth_data;
	}

	public PocketCreditResp credit(@QueryParam("amount") Double amount)
			throws JsonParseException, JsonMappingException, IOException {
		return convertToJSON(client.credit(amount), PocketCreditResp.class);
	}
}
