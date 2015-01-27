package com.tyan.ai.frame.enabler;

import java.util.HashMap;

public class EnaberMap {
	private static HashMap<String, EnableModel> map;
	//private HashMap<String, List<EnableModel>> map;
	static {
		map = new HashMap<String, EnableModel>();
	}
	
	public static void addEnabler(EnableModel emodel){
		if(!map.containsKey(emodel.getName()))
			map.put(emodel.getName(), emodel);
	}
	
	public static EnableModel getEnablerByName(String name){
		if(!map.containsKey(name))
			return null;
		else
			return map.get(name);
	}
	
	
	
}
