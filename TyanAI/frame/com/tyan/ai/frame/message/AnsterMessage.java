package com.tyan.ai.frame.message;

import com.tyan.ai.tool.HibernateTool;

public class AnsterMessage extends Message {
	
	public AnsterMessage() {
	}
	public AnsterMessage(String anster) {
		super(anster);
	}
	public static void main(String[] args) {
		AnsterMessage am = new AnsterMessage("哈哈哈");
		HibernateTool.save(am);
	}
}
