package com.tyan.ai.frame.enabler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Enabler {

	//可以优化，全部阴阳表示
	private static List<StateType> allState;
	// private static List<String> allStateString;

	private HashMap<String, State> states;

	public LinkedHashMap<String, Boolean> getStatesBoolean() {
		LinkedHashMap<String, Boolean> bs = new LinkedHashMap<String, Boolean>();
		for (String key : states.keySet()) {
			State s = states.get(key);
			bs.put(key, s.judgeBoolean());
		}
		return bs;
	}

	static {
		allState = Arrays.asList(StateType.values());
		for (StateType estate : allState) {
			State state = new State(estate.name());
			// allStateString.add(estate.name());
		}
	}

	/*
	 * public static List<String> getAllStateString(){ return allStateString; }
	 */

	public static List<StateType> getAllState() {
		return allState;
	}

	public Enabler() {
		states = new LinkedHashMap<String, State>();
		for (StateType estate : allState) {
			State state = new State(estate.name());
			states.put(estate.name(), state);
		}
	}

	public boolean stateTransition(String state, String newState) {
		if (!allState.contains(state)) {
			System.out.println("stateTransition error!!!!!!!!!!!!!!!!");
			return false;
		}
		states.get(state).addNewState(newState);
		return true;
	}

}
