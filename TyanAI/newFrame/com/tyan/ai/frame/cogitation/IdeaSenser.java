package com.tyan.ai.frame.cogitation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.tyan.ai.frame.enabler.EnableModel;

import com.tyan.ai.frame.knowledge.KnowledgeManager;
import com.tyan.ai.frame.knowledge.KnowledgeModel;
import com.tyan.ai.frame.logic.LogicModel;
import com.tyan.ai.frame.segMap.Seger;

public class IdeaSenser {
	
	static{
		Init();
	}

	//super unfinished
	public static void input(List<KnowledgeModel> klgs, LogicModel lmodel){
		LinkedHashMap<Integer, EnableModel> mark = new LinkedHashMap<Integer, EnableModel>();
		for(int i=0; i<klgs.size(); i++){
			if(klgs.get(i).getEnablerModel() != null)
				mark.put(i, klgs.get(i).getEnablerModel());
		}
		for(Integer i : mark.keySet()){
			
		}
	}
	
	
	public static void makeConnection(EnableModel emodel, KnowledgeModel kmodel){
		LogicModel lmodel = new LogicModel();
		kmodel.setLogic(lmodel);
		EnablerConnector.makeConnector(emodel, lmodel);
	}
	
	//super unfinished
	public static void BecauseSo(String because, String so){
		List<KnowledgeModel> becauseKlgs = KnowledgeManager.getKnoeledges(Seger.getSegFake(because));
		List<KnowledgeModel> soKlgs = KnowledgeManager.getKnoeledges(Seger.getSegFake(so));
		
		LinkedHashMap<Integer, EnableModel> soMark = new LinkedHashMap<Integer, EnableModel>();
		LinkedHashMap<Integer, EnableModel> becauseMark = new LinkedHashMap<Integer, EnableModel>();
		
		List<EnableModel> soEbs = new ArrayList<EnableModel>();
        List<EnableModel> becauseEbs = new ArrayList<EnableModel>();  

		KnowledgeModel beSenseklg = null;
		
		for(int i=0; i<soKlgs.size(); i++){//furtrue 融合成一个
			if(soKlgs.get(i).getEnablerModel() != null){
				soMark.put(i, soKlgs.get(i).getEnablerModel());
				soEbs.add(soKlgs.get(i).getEnablerModel());
				}
		}
		
		for(int i=0; i<becauseKlgs.size(); i++){
			KnowledgeModel klg = soKlgs.get(i);
			if(klg.getAttribute("type").equals("abstract")){
				//unfinished
				if(klg.getLogic() == null)
					beSenseklg = klg;
				else
			}
		}
		
		//unfinished
		makeConnection(soEbs.get(0), beSenseklg);
		
		
		
	}
	
	
	
	public static void Init(){
		//part1 
		String s1 = "A 怕 B";
		String s2 = "A 躲 起来";
		
		IdeaSenser.BecauseSo(s1, s2);
		
		//part2
		
		//part3
	}
	
}
