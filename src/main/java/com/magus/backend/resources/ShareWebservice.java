package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.client.CorporateAPIClient;
import com.magus.backend.model.ShareTransaction;

@Path("/share")
public class ShareWebservice extends AbstractService {

	CorporateAPIClient client = new CorporateAPIClient();
	
	@GET
	@Path("/share")
	@Produces(MediaType.APPLICATION_JSON)
	public ShareTransaction getCorpAccSumm(/*TODO*/) throws JsonParseException, JsonMappingException, IOException{
		return new ShareTransaction();//TODO
	}
	
}

