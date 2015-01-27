package com.tyan.ai.frame.logic;

import java.io.Serializable;

public class LogicalUnit {
	
	enum Type{
		nonReflection, Reflection
	}
	
	private Type type;
	private String id;
	
	public LogicalUnit(String type) {
		switch (type) {
		case "nonReflection":
			this.type = Type.nonReflection;
			break;
		case "Reflection":
			this.type = Type.Reflection;
			break;
		default:
			break;
		}
	}
}
