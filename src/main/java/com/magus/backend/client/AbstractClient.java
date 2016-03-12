package com.magus.backend.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.magus.backend.model.APIConstants;

public class AbstractClient {

	private static WebTarget webTarget = null;

	public static WebTarget getWebTarget() {
		if (webTarget == null) {
			ClientConfig conf = new ClientConfig();
			Client client = ClientBuilder.newClient(conf);

			webTarget = client.target(APIConstants.RETAIL_BASE_URL);
		}
		return webTarget;
	}

	public String getResponse(Response response) {
		String ans = "Something went Wrong, Code :" + response.getStatus();
		if (response.getStatus() <= 299 && response.getStatus() >= 200) {
			ans = response.readEntity(String.class);
		}
		return ans.substring(ans.indexOf("[")+1, ans.lastIndexOf("]"));
	}

	public WebTarget queryClientToken(WebTarget webTarget) {
		return webTarget.queryParam(APIConstants.CLIENT_ID_STR, APIConstants.CLIENT_ID_VALUE)
				.queryParam(APIConstants.TOKEN_STR, APIConstants.TOKEN_VALUE);
	}

	public AbstractClient() {
		super();
	}

}