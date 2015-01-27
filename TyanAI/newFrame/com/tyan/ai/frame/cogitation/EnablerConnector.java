package com.tyan.ai.frame.cogitation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.logic.LogicModel;

public class EnablerConnector {
	
	//private static LinkedHashMap<String, Boolean> connectSwitch;
	
	public static void init(){
		
	}
	
	public void getCLogicalModel(){
		
	}
	
	public static List<EnableModel> getCEnablerModel(LogicModel lmodel){
		return ConnectorNuclear.getCEnablerModel(lmodel);
	}
	
	static{
		/*connectSwitch = new LinkedHashMap<String, Boolean>();
		StateType[] allState = StateType.values();
		for(StateType estate : allState){
			connectSwitch.put(estate.name(), false);
		}*/
	}
	
	public static void makeConnector(EnableModel emodel, LogicModel lmodel){
		ConnectorNuclear.makeLink(emodel, lmodel);
	}
	
	
	
	static class ConnectorNuclear{
		private static BidiMap<YaoArray, LogicModel> YLconnector;
		private static BidiMap<List<EnableModel>, YaoArray> EsYconnector;
		
		static{
			YLconnector = new DualHashBidiMap<YaoArray, LogicModel>();
			EsYconnector = new DualHashBidiMap<List<EnableModel>, YaoArray>();
		}
		
		public static void makeLink(EnableModel emodel, LogicModel lmodel){
			EModelInterpreter.interpreter(emodel);
			//connector.put(emodel, lmodel);
			YaoArray yaoarray = YaoMaker.makeYaoArray(emodel);
			if(EsYconnector.getKey(yaoarray) != null)
				EsYconnector.getKey(yaoarray).add(emodel);
			else {
				List<EnableModel> es = new ArrayList<EnableModel>();
				es.add(emodel);
				EsYconnector.put(es, yaoarray);
			}
			YLconnector.put(yaoarray, lmodel);
		}
		
		public static List<EnableModel> getCEnablerModel(LogicModel lmodel){
			YaoArray y = YLconnector.getKey(lmodel);
			List<EnableModel> es = EsYconnector.getKey(y);
			return es;
		}
	}

}
