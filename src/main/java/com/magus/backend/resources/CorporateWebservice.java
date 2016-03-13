package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.client.CorporateAPIClient;
import com.magus.backend.model.CorpAccountSummary;
import com.magus.backend.model.RelationManager;

@Path("/corporate")
public class CorporateWebservice extends AbstractService {

	CorporateAPIClient client = new CorporateAPIClient();
	
	@GET
	@Path("/accountSummary")
	@Produces(MediaType.APPLICATION_JSON)
	public CorpAccountSummary getCorpAccSumm(@QueryParam ("corpid") String corpid, @QueryParam("userid") String userid) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.accountSummary(corpid, userid), CorpAccountSummary.class);
	}
	
	@GET
	@Path("/showRM")
	@Produces(MediaType.APPLICATION_JSON)
	public RelationManager getShowRM(@QueryParam ("corpid") String corpid, @QueryParam("userid") String userid) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.showRM(corpid, userid), RelationManager.class);
	}
	
	@GET
	@Path("/corpRMQuery")
	@Produces(MediaType.APPLICATION_JSON)
	public RelationManager getCorpRMQuery(@QueryParam ("corpid") String corpid, @QueryParam("userid") String userid) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.showRM(corpid, userid), RelationManager.class);
	}
}

