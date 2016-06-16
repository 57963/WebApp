package com.webapp;

import java.sql.Timestamp;

public class Message {
	public int ID;
	public int from;
	public int to;
	public Timestamp timestamp;
	public String content;
	public boolean read;
	
	public Message(int ID,int from, int to, Timestamp timestamp, String content,boolean read){
		this.ID = ID;
		this.from = from;
		this.to = to;
		this.timestamp = timestamp;
		this.content = content;
		this.read = read;
	}

	public int getID() {
		return ID;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public String getContent() {
		return content;
	}

	public boolean isRead() {
		return read;
	}
}
