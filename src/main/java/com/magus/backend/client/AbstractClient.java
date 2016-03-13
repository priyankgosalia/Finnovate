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

	public String getResponse(Response response) {
		String ans = "{ \"code\":" +  response.getStatus() + ",\"description\":\"Access Denied\",\"message\":\"Something went Wrong\"}";
		if (response.getStatus() <= 299 && response.getStatus() >= 200) {
			ans = response.readEntity(String.class);
		}
		return trimOff_START_ARRAY(ans);
	}

	
	public String getResponse(Response response, String dummyResponse) {
		String ans = "{ \"code\":" +  response.getStatus() + ",\"description\":\"Access Denied\",\"message\":\"Something went Wrong\"}";
		if (response.getStatus() <= 299 && response.getStatus() >= 200) {
			ans = response.readEntity(String.class);
		}
		if(ans.contains("\"code\":401")){
			return trimOff_START_ARRAY(dummyResponse);
		}
		return trimOff_START_ARRAY(ans);
	}

	private String trimOff_START_ARRAY(String ans) {
		if(ans.indexOf("[") == 0 && ans.lastIndexOf("]") > 0)
		ans.substring(ans.indexOf("[")+1, ans.lastIndexOf("]"));
		
		//String resp = ans.substring(ans.indexOf('}'),ans.length());
		
		return ans.substring(ans.indexOf('}')+2,ans.length());
	}
	
	public WebTarget queryClientToken(WebTarget webTarget) {
		return webTarget.queryParam(APIConstants.CLIENT_ID_STR, APIConstants.CLIENT_ID_VALUE)
				.queryParam(APIConstants.TOKEN_STR, APIConstants.TOKEN_VALUE);
	}

	public AbstractClient() {
		super();
	}

}