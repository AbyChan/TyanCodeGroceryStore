package com.tyan.ai.frame.cogitation;

import java.io.IOException;
import java.util.List;

import com.tyan.ai.frame.enabler.EnablerMaker;
import com.tyan.ai.frame.knowledge.Assembler;
import com.tyan.ai.frame.knowledge.KnowledgeManager;
import com.tyan.ai.frame.knowledge.KnowledgeModel;
import com.tyan.ai.frame.memory.MemoryManager;
import com.tyan.ai.frame.memory.MemoryMap;
import com.tyan.ai.frame.segMap.Seger;

public class MainThinking {
	
	public static void input(String sentense, MemoryManager memoryManager) throws IOException {
		
		List<String> seged = Seger.getSegFake(sentense);
		List<KnowledgeModel> klgs = KnowledgeManager.getKnoeledges(seged);
		putIntoMemory(klgs, memoryManager);
	}
	
	
	public static void putIntoMemory(List<KnowledgeModel> klgs, MemoryManager memoryManager){
		
	}

	private static void KMMerge(){
		
	}
	
	private static void processLogic(){
		
	}
	
	private static void processLogicMR(){
		
	}
	
	


	
	public static void main(String[] args) throws IOException {
		//Assembler.main();
		String s1 = "小红:activeSide 怕:bridge 大灰狼:accepted";
		
		initEnablerConnector();
		IdeaSenser.Init();
		
		
		MemoryMap memoryMap = new MemoryMap();
		MemoryManager memoryManager = new MemoryManager(memoryMap);
		
		input(s1, memoryManager);
		
		String question_part1 = "小红:activeSide 见到:bridge 大灰狼:accepted";
		//String roles1 = "";
		String question_part2 = "小红:keyman 会:qword 怎么样:qword ？";
		
		ParseQuestion.contextInput(Seger.getWRFake(question_part1));
		ParseQuestion.realQuestionInput(Seger.getWRFake(question_part2));
		ParseQuestion.returnAnster(memoryManager);
	}
	
	public static void initEnablerConnector() throws IOException{
		EnablerMaker.InitteachInput();
	}

}
