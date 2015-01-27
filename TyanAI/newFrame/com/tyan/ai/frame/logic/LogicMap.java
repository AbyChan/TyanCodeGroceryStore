package com.tyan.ai.frame.logic;

import java.util.HashMap;

public class LogicMap {
	
	private static HashMap<String, LogicModel> logicEntrance = new HashMap<String, LogicModel>();
	
	public static void putLM(LogicModel lmodel){
		String name = lmodel.getName();
		if(logicEntrance.containsKey(name))
			System.out.println("this lmodel has exited");
		else{
			logicEntrance.put(name, lmodel);
		}
	}
	
	public static LogicModel getLM(String name) {
		if (!logicEntrance.containsKey(name)) {
			System.out.println("have not this lmodel");
			return null;
		} else {
			return logicEntrance.get(name);
		}
	}

}
