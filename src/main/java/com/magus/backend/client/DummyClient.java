package com.magus.backend.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

public class DummyClient extends AbstractClient {

	public String isKYCDone(String uid){
		ClientConfig conf = new ClientConfig();
		Client client = ClientBuilder.newClient(conf);

		WebTarget webTarget = client.target("http://localhost:8080/magus/ws/authenticate/kyc").queryParam("uid", uid);
 
		String resp = webTarget.request(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		return resp;
	}
}
