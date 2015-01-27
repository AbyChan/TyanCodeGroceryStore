package com.tyan.ai.AIMain;

import java.util.List;
import java.util.Map.Entry;

public class KLGInput {
	private String modelClass;
	private String name;
	private List<Entry<String, String>> attribute;
	
	public KLGInput(String modelClass, String name, List<Entry<String, String>> attribute) {
		this.modelClass = modelClass;
		this.name = name;
		this.attribute = attribute;
	}
	public String getModelClass() {
		return modelClass;
	}
	public void setModelClass(String modelClass) {
		this.modelClass = modelClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Entry<String, String>> getAttribute() {
		return attribute;
	}
	public void setAttribute(List<Entry<String, String>> attribute) {
		this.attribute = attribute;
	}
	

}
