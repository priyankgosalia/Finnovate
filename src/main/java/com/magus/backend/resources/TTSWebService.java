package com.magus.backend.resources;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.magus.backend.texttospeech.TTSClient;

@Path("/texttospeech")
public class TTSWebService extends AbstractService {

	TTSClient client = new TTSClient();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getResponse() {
		return "Successful";
	}
	
//	@GET
//	@Path("/say")
//	@Produces("audio/x-wave")
//	public InputStream getSpeechFromText(@QueryParam("input") String input) {
//		return client.convertToSpeech(input);
//	}
	
}
