package com.tyan.ai.frame.cogitation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.tyan.ai.frame.enabler.Enabler;
import com.tyan.ai.frame.enabler.StateType;

public class YaoArraySetting {
	
	private static List<String> setting;
	
	static{
		loadSetting();
	}
	
	private static void loadSetting(){
		List<StateType> ea = Enabler.getAllState();
		setting = new ArrayList<String>();
		for(StateType st : ea){
			setting.add(st.name());
		}
		
	}
	
	public static List<String> getSetting(){
		return setting;
	}
}
