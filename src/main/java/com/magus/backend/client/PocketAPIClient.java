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

	public String credit(String amount){
		WebTarget webTarget = getWebTarget().path(APIConstants.CREDIT_WALLET);
		Form form = new Form();
		form.param("id_type", "TOKEN"); 
		form.param("id_value", "abcVxAfkBTN7t3jjnrdw"); 
		form.param("auth_type", "TOKEN"); 
		form.param("auth_data", "2d9c2fe842854b079bb2"); 
		form.param("txn_id", "123498"); 
		form.param("amount", amount); 
		form.param("promocode", "pockt1234"); 
		form.param("remarks", "Cake shop"); 
		form.param("sub_merchant", "Cakerina"); 
		form.param("latitude", "19.11376955"); 
		form.param("longitude", "73.8500124"); 
		form.param("imei", "35550702720000"); 
		form.param("device_id", "7b47c06dsj12243"); 
		form.param("ip_address", "194.154.205.26"); 
		form.param("os", "android");
		
		//webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(form, MediaType.APPLICATION_JSON),PocketPostCredit.class);
		return DummyReponses.getPocketCredit(amount);
	}
	
	public static void main(String[] args) {
		PocketAPIClient client = new PocketAPIClient();
		
		WalletProfile wallet = new WalletProfile("Prajot","Naik","prajot@gmail.com","9910111101","1985-08-01","male","10.10.200.200","windows","none","abc");
		System.out.println(client.create(wallet));
	}

}
