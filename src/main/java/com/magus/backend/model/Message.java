package com.magus.backend.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@XmlRootElement
public class Message {

	public Message() {
		// TODO Auto-generated constructor stub
	}
	private String id;
	private String createdBy;
	private Date createdOn;
	private String message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Message(String id, String createdBy, String message) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.createdOn = new Date();
		this.message = message;
	}
	
	
}
