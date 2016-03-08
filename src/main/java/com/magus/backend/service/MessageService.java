package com.magus.backend.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.magus.backend.db.DatabaseDumm;
import com.magus.backend.model.Message;

public class MessageService {

	private Map<String, Message> messages = DatabaseDumm.getMessages();
	
	public List<Message> getMessagesList(){
		return new ArrayList(messages.values());
	}
	
	public Message getMessage(String id){
		return messages.get(id);
	}
	
	public Message updateMessage(Message mess){
		messages.put(mess.getId(), mess);
		
		return messages.get(mess.getId());
	}
	
	public Message addMessage(Message mess){
		int size = messages.size();
		mess.setCreatedOn(new Date());
		mess.setId(String.valueOf(size + 1));
		messages.put(String.valueOf(size + 1), mess);
		
		return messages.get(size);
	}
	
	public Message deleteMessage(String id){
		return messages.remove(id);
	}
	
	public List<Message> getAllMessages(int year){
		List<Message> msgs = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		for(Message msg : messages.values()){
			cal.setTime(msg.getCreatedOn());
			if(cal.get(Calendar.YEAR) == year){
				msgs.add(msg);
			}
		}
		
		return msgs;
		
	}
	
	public List<Message> getPaginatedMessage(int start, int size){
		ArrayList<Message> msgs = new ArrayList<>(messages.values());
		if(start + size > msgs.size()){
			return msgs;
		}
		return msgs.subList(start, start + size);
		
	}
}
