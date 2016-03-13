package com.magus.backend.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.magus.backend.service.DummyService;

@Path("/authenticate")
public class DummyResource {

	//MessageService msgS = new MessageService();
	DummyService service = new DummyService();
	
/*	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return msgS.getMessagesList();	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam ("year") int year){
		if(year >0 )
		return msgS.getAllMessages(year);
		
		return msgS.getMessagesList();
	}*/

	@GET
	@Path("/{aadhar}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMessage(@PathParam("aadhar") String uid){
		return service.isKYCed(uid);	
	}
	
/*	@POST
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
	}*/
	
}
