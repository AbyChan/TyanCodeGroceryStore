package com.tyan.ai.frame.message;

import com.tyan.ai.tool.HashTool;

public class Message {
	protected String message;
	long hashValue;
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message(String message) {
		this.message = message;
		hashValue = HashTool.BKDRHash(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getHashValue() {
		return hashValue;
	}
	public void setHashValue(long hashValue) {
		this.hashValue = hashValue;
	}


}
