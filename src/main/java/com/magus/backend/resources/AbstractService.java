package com.magus.backend.resources;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractService {
	protected static ObjectMapper mapper = new ObjectMapper();
	
	protected static <T> T convertToJSON(String jsonStr, Class<T> klass) throws JsonParseException, JsonMappingException, IOException {
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
		//2016-03-23 12:56:44.0
		mapper.setDateFormat(df);
		return mapper.readValue(jsonStr, klass);
	}
	
}
