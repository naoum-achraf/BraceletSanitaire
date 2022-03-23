package com.CiH.Messagerie;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.CiH.login.models.User;

@Entity
public class Messagerie {
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	User Sender;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	User Receiver;
	
	String nameSender;
	
	public Messagerie() {
	}
	
	public Messagerie(Long id, User sender, User receiver, String nameSender, String message) {
		super();
		this.id = id;
		Sender = sender;
		Receiver = receiver;
		this.nameSender = nameSender;
		this.message = message;
	}

	public String getNameSender() {
		return nameSender;
	}

	public void setNameSender(String nameSender) {
		this.nameSender = nameSender;
	}

	String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return Sender;
	}

	public void setSender(User sender) {
		Sender = sender;
	}

	public User getReceiver() {
		return Receiver;
	}

	public void setReceiver(User receiver) {
		Receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Messagerie(Long id, User sender, User receiver, String message) {
		super();
		this.id = id;
		Sender = sender;
		Receiver = receiver;
		this.message = message;
	}
	
	


	
}
