package com.tyan.ai.frame.cogitation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.enabler.Enabler;

public class YaoMaker {
		//Unfinished relation-wait
		public static YaoArray makeYaoArray(EnableModel emodel){
			List<String> setting = YaoArraySetting.getSetting();
			Enabler ea = emodel.getEnabler();
			LinkedHashMap<String, Boolean> bs = ea.getStatesBoolean();
			LinkedHashMap<String, Boolean> yaoa = new LinkedHashMap<String, Boolean>();
			for(String s : setting){
				boolean defaultb = false;
				for(String bss : bs.keySet()){
					if(bss.equals(s))
						defaultb = bs.get(bss);
				}
				yaoa.put(s, defaultb);
			}
			
			
			boolean[] cb = new boolean[yaoa.values().size()];
			for(int i=0; i<cb.length; i++){
				cb[i] = (boolean) yaoa.values().toArray()[i];
			}
			
			YaoArray ya = new YaoArray(cb);
			return ya;
		}
}
