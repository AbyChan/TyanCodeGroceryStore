package com.tyan.ai.frame.enabler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {
	private static final String THIS = "this";

	private String name;
	
	private List<String> statetransition;
	private HashMap<String, String> stateDescription;
	
	public boolean judgeBoolean(){
		if(getTransitionLength() == 1)
			return false;
		else
			return true;
	}
	
	public State(String name) {
		this.name = name;
		statetransition = new ArrayList<String>();
		//statetransition.add(THIS);
	}
	
	public void addNewState(String newState){
		statetransition.add(newState);
	}
	
	public void addDescription(String state, String description){
		if(stateDescription == null)
			stateDescription = new HashMap<String, String>();
		if(!stateDescription.containsKey(state))
			stateDescription.put(state, description);
	}
	
	

	public String getName() {
		return name;
	}

	
	public int getTransitionLength(){
		return stateDescription.size();
	}
	
	
}
