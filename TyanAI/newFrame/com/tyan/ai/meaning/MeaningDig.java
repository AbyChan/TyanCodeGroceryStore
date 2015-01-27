package com.tyan.ai.meaning;

import java.util.LinkedHashMap;
import java.util.List;

import com.tyan.ai.frame.enabler.Enabler;
import com.tyan.ai.frame.knowledge.KnowledgeModel;
import com.tyan.ai.frame.logic.LogicManager;
import com.tyan.ai.frame.logic.LogicModel;

public class MeaningDig {
	//private static LinkedHashMap<Integer, KnowledgeModel> cacheKlgs;
	
	public static void input(List<KnowledgeModel> klgs){
		generateMeaningModel(klgs);
	}
	
	
	//logical fake
	public static void generateMeaningModel(List<KnowledgeModel> klgs){
		MeaningModel mm = new MeaningModel();
		LinkedHashMap<Integer, LogicModel> marks = LogicManager.getAllLogicModel(klgs);
		//fake
		mm.input(klgs.get(0), "activeSide");
		mm.input(klgs.get(1), "bridge");
		mm.input(klgs.get(2), "accepted");
		
		//real
		LinkedHashMap<Integer, Enabler> mark = new LinkedHashMap<Integer, Enabler>();
		
	}
		
	public static void SortInput(List<KnowledgeModel> klgs){
		//reduced
	}
	
	
	public static void put2MM(MeaningModel mm, List<KnowledgeModel> klgs, List<String> roles) {
		for(int i=0; i<klgs.size(); i++){
			mm.input(klgs.get(i), roles.get(i));
		}
	}

	public static void putQ2MM(MeaningModel mm, List<KnowledgeModel> klgs, List<String> roles) {
		mm.parseIntend(klgs, roles);
	}


}
