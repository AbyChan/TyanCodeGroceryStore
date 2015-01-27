package com.tyan.ai.frame.cogitation;

import java.util.LinkedHashMap;
import java.util.List;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.enabler.Enabler;
import com.tyan.ai.frame.knowledge.KnowledgeManager;
import com.tyan.ai.frame.knowledge.KnowledgeModel;
import com.tyan.ai.frame.logic.LogicModel;
import com.tyan.ai.frame.memory.MemoryManager;
import com.tyan.ai.frame.segMap.Seger;
import com.tyan.ai.frame.segMap.WaR;
import com.tyan.ai.meaning.MeaningDig;
import com.tyan.ai.meaning.MeaningModel;

public class ParseQuestion {
	private static List<WaR> context;
	private static List<WaR> realQuestion;
	
	public static void input(List<String> seged, List<String> roles){
		
	}
	
	public static void contextInput(List<WaR> context){//, List<String> roles){
		ParseQuestion.context = context;
	}
	
	public static void realQuestionInput(List<WaR> realQuestion){//, List<String> roles){
		ParseQuestion.realQuestion = realQuestion;
	}
	
	//public static void 
	
	//super unfinished
	public static String returnAnster(MemoryManager memoryManager){
		List<KnowledgeModel> contextKlgs = KnowledgeManager.getKnoeledges(Seger.getAllWord(context));
		//unfinished
		LinkedHashMap<EnableModel, Integer> eMark = getAllEnbler(contextKlgs);
		//put to meaningmodel
		
		MeaningModel mm = new MeaningModel();
		
		//fake
		List<KnowledgeModel> qstKlgs = KnowledgeManager.getKnoeledges(Seger.getAllRole(realQuestion));
		
		
		
		List<String> ctRoles = Seger.getAllRole(context);
		List<String> qstRoles = Seger.getAllRole(realQuestion);
		
		
		
		MeaningDig.put2MM(mm, contextKlgs, ctRoles);
		
		
		
		MeaningDig.putQ2MM(mm, qstKlgs, qstRoles);
		
		
		// find role in everyklg  make list and input 
		
		// input no code-rule from seged or klg
		
		//meaning unit
		
		//meaning make role first , meet Be then turn x
		
		//question: find who-link-who what action
		
		return null;
	}
	
	public static String findInMM(MeaningModel mm, MemoryManager memoryManager){
		if(!mm.hasIntend())
			System.out.println("this model not has Intend");
		else{
			String name = mm.getIntend().getKeyman().getName();
			return memoryManager.search(name).getAfterlink().get(0).getLinkname();
			
		}
		return null;
	}
	
	
	
	public static LinkedHashMap<EnableModel, Integer> getAllEnbler(List<KnowledgeModel> klgs){
		LinkedHashMap<EnableModel, Integer> marks = new LinkedHashMap<EnableModel, Integer>();
		for(int i=0; i<klgs.size(); i++){
			LogicModel lm = klgs.get(i).getLogic();
			if(lm != null){
				List<EnableModel> es = EnablerConnector.getCEnablerModel(lm);
				for(EnableModel e : es)
					marks.put(e, i);
			}
			EnableModel e = klgs.get(i).getEnablerModel();
			if(e != null)
				marks.put(e, i);
		}
		return marks;
		
	}
}
