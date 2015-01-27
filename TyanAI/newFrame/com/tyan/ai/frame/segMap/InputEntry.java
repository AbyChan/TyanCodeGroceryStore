package com.tyan.ai.frame.segMap;

import java.util.Map.Entry;

public class InputEntry implements Entry<String, String> {
	private String word;
	private String tag;
	public InputEntry(String key ,String value) {
		word = key;
		tag = value;
	}
	@Override
	public String getKey() {
		return word;
	}
	@Override
	public String getValue() {
		return tag;
	}
	@Override
	public String setValue(String value) {
		String temp = word;
		word = value;
		return temp;
	}

}
