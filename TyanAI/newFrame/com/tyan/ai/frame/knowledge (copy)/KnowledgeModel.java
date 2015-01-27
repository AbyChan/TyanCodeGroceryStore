package com.tyan.ai.frame.knowledge;

import java.io.Serializable;
import java.util.HashMap;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.logic.LogicModel;
import com.tyan.ai.frame.logic.LogicalUnit;

public abstract class KnowledgeModel implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6035854329414853844L;
	private String name;
	protected HashMap<String, String> attribute;
	
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	abstract public LogicModel getLogic();
	abstract public EnableModel getEnablerModel();
	abstract public void setLogic(LogicModel lmodel);
	
	public KnowledgeModel(String name) {
		this.name = name;
		attribute = new HashMap<String, String>();
	}
	
	public void show(){
		System.out.println(name);
		System.out.println(attribute);
	}
	
	abstract public void addAttribute(String key, String value);
	
	public String getName(){
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}
