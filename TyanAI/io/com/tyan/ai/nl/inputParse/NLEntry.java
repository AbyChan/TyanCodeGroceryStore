package com.tyan.ai.nl.inputParse;

import java.util.Map.Entry;

public class NLEntry implements Entry<String, Object> {
	private String key;
	private Object value;
	
	public NLEntry(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Object setValue(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
