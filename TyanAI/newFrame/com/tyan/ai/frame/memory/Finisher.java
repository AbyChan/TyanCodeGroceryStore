package com.tyan.ai.frame.memory;

import java.util.ArrayList;
import java.util.List;

import com.tyan.ai.frame.knowledge.KnowledgeModel;

public class Finisher {

	public static List<KnowledgeModel> filterKnowledge(List<KnowledgeModel> klgs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//meaningmodel
	public static List<List<KnowledgeModel>> filterKnowledgeFake(List<KnowledgeModel> klgs) {
		List<List<KnowledgeModel>> returns = new ArrayList<List<KnowledgeModel>>();
		for(KnowledgeModel klg : klgs){
			List<KnowledgeModel> part = new ArrayList<KnowledgeModel>();
			part.add(klg);
			returns.add(part);
		}
		return returns;
	}

}
