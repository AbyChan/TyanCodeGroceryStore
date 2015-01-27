package com.tyan.ai.frame.knowledge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KnowledgeMap {

	private static HashMap<String, List<KnowledgeModel>> knowledgeSet;
	
	static{
		knowledgeSet = new HashMap<String, List<KnowledgeModel>>();
	}
	
	public static HashMap<String, List<KnowledgeModel>> getEntrance(){
		return knowledgeSet;
	}
	
	public static List<KnowledgeModel> search(String name){
		if( knowledgeSet.containsKey(name) ){
			List<KnowledgeModel> kmSet = knowledgeSet.get(name);
			return kmSet;
		}else {
			return null;
		}
	}
	
	public static void put(String name, KnowledgeModel km){
		if( knowledgeSet.containsKey(name) ){
			knowledgeSet.get(name).add(km);
		}else{
			List<KnowledgeModel> kmList = new ArrayList<KnowledgeModel>();
			kmList.add(km);
			knowledgeSet.put(name, kmList);
		}
	}
	
}
