package com.magus.backend.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.magus.backend.model.APIConstants;

public class AbstractClient {

	private static WebTarget webTarget = null;
	private String BASE_URL = "";

	public void setBASE_URL(String bASE_URL) {
		BASE_URL = bASE_URL;
	}

	public WebTarget getWebTarget() {
		if (webTarget == null) {
			ClientConfig conf = new ClientConfig();
			Client client = ClientBuilder.newClient(conf);

			webTarget = client.target(BASE_URL);
		}
		return webTarget;
	}
	public String getVanillaResponse(Response response) {
		return response.readEntity(String.class);
	}

	public String getResponse(Response response) {
		String ans = checkStatus(response);
		return trimOff_START_ARRAY(ans);
	}

	private String checkStatus(Response response) {
		String ans = "{ \"code\":" +  response.getStatus() + ",\"description\":\"Access Denied\",\"message\":\"Something went Wrong\"}";
		if (response.getStatus() <= 299 && response.getStatus() >= 200) {
			ans = response.readEntity(String.class);
		}
		return ans;
	}

	
	public String getResponse(Response response, String dummyResponse) {
		String ans = checkStatus(response);
		if(ans.contains("\"code\":401")){
			return trimOff_START_ARRAY(dummyResponse);
		}
		return trimOff_START_ARRAY(ans);
	}

	private String trimOff_START_ARRAY(String ans) {
		String reply = ans;
		if(reply.indexOf("[") == 0 && reply.lastIndexOf("]") > 0)
			reply = reply.substring(reply.indexOf("[")+1, reply.lastIndexOf("]"));
		
		//String resp = ans.substring(ans.indexOf('}'),ans.length());
		if(!reply.substring(reply.indexOf('}')+1, reply.indexOf('}') +2 ).equalsIgnoreCase(",")){
			return reply;
		}
		return reply.substring(reply.indexOf('}')+2,reply.length());
	}
	
	public WebTarget queryClientToken(WebTarget webTarget) {
		return webTarget.queryParam(APIConstants.CLIENT_ID_STR, APIConstants.CLIENT_ID_VALUE)
				.queryParam(APIConstants.TOKEN_STR, APIConstants.TOKEN_VALUE);
	}

	public WebTarget pathClientToken(WebTarget webTarget) {
		return webTarget.path(APIConstants.CLIENT_ID_VALUE)
				.path(APIConstants.TOKEN_VALUE);
	}
	public WebTarget query(WebTarget webTarget) {
		return webTarget;
	}

	public AbstractClient() {
		super();
	}

}