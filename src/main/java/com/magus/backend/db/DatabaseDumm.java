package com.magus.backend.db;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;

import com.magus.backend.model.Message;

public class DatabaseDumm {

	private static Map<String, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiless = new HashMap<>();
	
	public static Map<String, Message> getMessages(){
		return messages;
	}

	public static Map<String, Profile> getProfiles(){
		return profiless;
	}
}
