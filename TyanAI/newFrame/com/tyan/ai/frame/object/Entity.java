package com.tyan.ai.frame.object;

public class Entity implements TyanObject {
	private String name;
	
	public Entity(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;

	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

}
