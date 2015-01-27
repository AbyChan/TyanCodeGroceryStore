package com.tyan.ai.frame.logic;

import com.tyan.ai.feeling.Feeling;

public class LogicModel {
	
	private String name;
	
	private LogicalUnit logicalU;
	
	private Feeling feeling;
	
	public LogicModel(String name, String lutype) {
		this.name = name;
		logicalU  = new LogicalUnit(lutype);
		feeling = null;
	}
	
	public String getName(){
		return name;
	}

	

}
