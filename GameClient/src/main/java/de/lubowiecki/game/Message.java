package de.lubowiecki.game;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 2005764192380318585L;
	
	private final LocalDateTime createdAt;
	private final String text;
	private final String user;
	
	public Message(String text, String user) {
		this.createdAt = LocalDateTime.now();
		this.text = text;
		this.user = user;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public String getText() {
		return text;
	}
	
	public String getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return createdAt + " ("+ user +"): " + text;
	}
}
