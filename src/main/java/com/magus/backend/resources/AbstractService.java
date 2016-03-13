package com.magus.backend.resources;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractService {
	private static ObjectMapper mapper = new ObjectMapper();
	
	protected static <T> T convertToJSON(String jsonStr, Class<T> klass) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonStr, klass);
	}
}
