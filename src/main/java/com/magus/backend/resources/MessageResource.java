package com.magus.backend.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.magus.backend.model.Message;
import com.magus.backend.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgS = new MessageService();
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return msgS.getMessagesList();	
	}*/

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(@QueryParam ("year") int year){
		if(year >0 )
		return msgS.getAllMessages(year);
		
		return msgS.getMessagesList();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("id") String id){
		return msgS.getMessage(id);	
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message mess){
		return msgS.addMessage(mess);
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("id") String id,Message mess){
		mess.setId(id);
		return msgS.updateMessage(mess);
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("id") String id){
		msgS.deleteMessage(id);
	}
	
}
