package com.tyan.ai.AIMain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tyan.ai.frame.knowledge.Assembler;
import com.tyan.ai.frame.knowledge.KnowledgeManager;
import com.tyan.ai.frame.segMap.InputEntry;

public class Brain {
	
	static class Fileinput{
		
		public static List<KLGInput> loadKnoeledgeInput() throws IOException{
			List<KLGInput> klgInputs = new ArrayList<KLGInput>();
			List<String> inputs = new ArrayList<String>();
			File file = new File("newFrame/com/tyan/ai/AIMain/KnowledgeInput");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while(line != null){
				inputs.add(line);
				line = br.readLine();
			}
			br.close();
			for(String fline : inputs){
				List<Entry<String, String>> attribute = new ArrayList<Entry<String, String>>();
				String[] cells = fline.split(" ");
				String modelClass = cells[0];
				String name = cells[1];
				//if(((cells.length - 1) % 2) != 0){
				//	System.out.println("Error  input file");
				//}else{
					for(int i=2; i<cells.length; i++){
						String[] kv = cells[i].split(":");
						Entry<String, String> ie = new InputEntry(kv[0],kv[1]);
						attribute.add(ie);
					}
				//}
				klgInputs.add(new KLGInput(modelClass, name, attribute));
			}
			return klgInputs;
		}
	}
	
	public static void teachFormOject(List<KLGInput> klgInputs){
		for(KLGInput klg : klgInputs){
			teachKnowledge(klg.getModelClass(), klg.getName(), klg.getAttribute());
		}
	}

	
	public static void teachKnowledge(String modelClass, String name, List<Entry<String, String>> input){
		KnowledgeManager.recognize(modelClass, name, input);
	}
	
	public static void main(String[] args) throws IOException {
		teachFormOject(Fileinput.loadKnoeledgeInput());
		KnowledgeManager.showAll();
	}
}
