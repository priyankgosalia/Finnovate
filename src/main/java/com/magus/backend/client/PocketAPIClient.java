package com.magus.backend.client;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.magus.backend.model.APIConstants;
import com.magus.backend.model.DummyReponses;
import com.magus.backend.model.PocketPostCredit;
import com.magus.backend.model.WalletProfile;

public class PocketAPIClient extends AbstractClient {

	public PocketAPIClient() {
		setBASE_URL(APIConstants.POCKET_BASE_URL);
	}
	
	//http://alphaiciapi2.mybluemix.net/rest/Wallet/createWallet/mer_123/create/Kavi/makode/km@gmail.com/7842133324/1989-07-12/male/10.22.7.74/android/12345/xyz/ujjwal.ju@gmail.com/93bea2128124
	public String create(WalletProfile wallet) {
		WebTarget webTarget = getWebTarget().path(APIConstants.CREATE_WALLET);
		Response response = pathClientToken(webTarget
				.path(APIConstants.MERCHANT).path("create").path(wallet.getFirstName())
				.path(wallet.getLastName()).path(wallet.getEmailId())
				.path(wallet.getMobile()).path(wallet.getBirthDate())
				.path(wallet.getGender()).path(wallet.getIpConfig())
				.path(wallet.getPlatform())
				.path(wallet.getDeviceId()).path(wallet.getState()))
				.request()
				.accept(MediaType.APPLICATION_JSON_TYPE).get();
		return DummyReponses.getPocketCreation();//getResponse(response, DummyReponses.getPocketCreation());
	}

	public String credit(Double amount){
		WebTarget webTarget = getWebTarget().path(APIConstants.CREDIT_WALLET);
		
		PocketPostCredit creditRequest = new PocketPostCredit();
		creditRequest.setId_type("TOKEN");
		creditRequest.setId_value("abcVxAfkBTN7t3jjnrdw");
		creditRequest.setAuth_type("TOKEN");
		creditRequest.setAuth_data("2d9c2fe842854b079bb2");
		creditRequest.setTxn_id("123498");
		creditRequest.setAmount(amount);
		creditRequest.setPromocode("pockt1234");
		creditRequest.setRemarks("Cake Shopp");
		creditRequest.setSub_merchant("Cakerina");
		creditRequest.setLatitude("19.11376955");
		creditRequest.setLongitude("73.8500124");
		creditRequest.setImei("35550702720000");
		creditRequest.setIp_address("194.154.205.26");
		creditRequest.setOs("android");
		
		Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(creditRequest, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
		//return DummyReponses.getPocketCredit(amount);
	}
	
	public static void main(String[] args) {
		PocketAPIClient client = new PocketAPIClient();
		
		WalletProfile wallet = new WalletProfile("Prajot","Naik","prajot@gmail.com","9910111101","1985-08-01","male","10.10.200.200","windows","none","abc");
		//System.out.println(client.create(wallet));
		System.out.println(client.credit(255.50));
	}

}
