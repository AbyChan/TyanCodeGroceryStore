package com.tyan.ai.frame.memory;

import java.util.List;

import com.tyan.ai.frame.knowledge.KnowledgeModel;
import com.tyan.ai.meaning.MeaningDig;

public class AMNodeMaker {
	
	public static void Input(List<KnowledgeModel> klgs){
//		List<List<KnowledgeModel>> fklgs = Finisher.filterKnowledgeFake(klgs);
//		makeAMNodeFake(fklgs);
		MeaningDig.input(klgs);
	} 
	
	private static void makeAMNodeFake(List<List<KnowledgeModel>> fklgs) {
		
	}

	public static void makeAMNode(List<KnowledgeModel> klgs){
		
	}
	
	

}
