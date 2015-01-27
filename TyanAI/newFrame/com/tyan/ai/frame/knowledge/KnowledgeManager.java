package com.tyan.ai.frame.knowledge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.tyan.ai.AIMain.KLGInput;
import com.tyan.ai.frame.segMap.InputEntry;

public class KnowledgeManager {
	
	//auto load
	static{
		try {
			teachFormOject(Fileinput.loadKnoeledgeInput());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KnowledgeManager.showAll();
	}
	
	public static List<String> getAllRole(List<KnowledgeModel> klgs){
		List<String> roles = new ArrayList<String>();
		for(KnowledgeModel klg : klgs)
			roles.add(klg.getRole());
		return roles;
	}
	
	
	public static void teachFormOject(List<KLGInput> klgInputs) {
		for (KLGInput klg : klgInputs) {
			teachKnowledge(klg.getModelClass(), klg.getName(),
					klg.getAttribute());
		}
	}

	public static void teachKnowledge(String modelClass, String name,
			List<Entry<String, String>> input) {
		KnowledgeManager.recognize(modelClass, name, input);
	}
	
	static class Fileinput {
		public static List<KLGInput> loadKnoeledgeInput() throws IOException {
			List<KLGInput> klgInputs = new ArrayList<KLGInput>();
			List<String> inputs = new ArrayList<String>();
			File file = new File("newFrame/com/tyan/ai/AIMain/KnowledgeInput");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				inputs.add(line);
				line = br.readLine();
			}
			br.close();
			for (String fline : inputs) {
				List<Entry<String, String>> attribute = new ArrayList<Entry<String, String>>();
				String[] cells = fline.split(" ");
				String modelClass = cells[0];
				String name = cells[1];
				// if(((cells.length - 1) % 2) != 0){
				// System.out.println("Error  input file");
				// }else{
				for (int i = 2; i < cells.length; i++) {
					String[] kv = cells[i].split(":");
					Entry<String, String> ie = new InputEntry(kv[0], kv[1]);
					attribute.add(ie);
				}
				// }
				klgInputs.add(new KLGInput(modelClass, name, attribute));
			}
			return klgInputs;
		}
	}
	
	public void preInitialized(){
		
	}
	
	public static void learn(String name, String[] meaning){
		
	}
	
	public static KnowledgeModel getKnowledge(String name){
		List<KnowledgeModel> kml = KnowledgeMap.search(name);
		if(kml.size() ==0 || kml == null)
			return null;
		return judgeWhich(kml);
		
	}
	
	//unfinished
	private static KnowledgeModel judgeWhich(List<KnowledgeModel> kml){
		return (KnowledgeModel) kml.toArray()[0];
	}
	
	public static void recognize(String modelClass,String name, List<Entry<String, String>> input){
		KnowledgeModel km = Assembler.makeKlgModel(modelClass, name, input);
		KnowledgeMap.put(name, km);
	}
	
	public static void showAll(){
		HashMap<String, List<KnowledgeModel>> knowledgeEntrance = 
				KnowledgeMap.getEntrance();
		for(String ename : knowledgeEntrance.keySet()){
			List<KnowledgeModel> lkm = knowledgeEntrance.get(ename);
			for(KnowledgeModel km : lkm){
				km.show();
			}
		}
	}

	public static List<KnowledgeModel> getKnoeledges(List<String> seged) {
			List<KnowledgeModel> klgl = new ArrayList<KnowledgeModel>();
			for (String seg : seged) {
				KnowledgeModel klg = KnowledgeManager.getKnowledge(seg);
				if(klg == null){
					KnowledgeModel uklg = new UnknownModel(seg);
					klgl.add(uklg);
					}
				else
					klgl.add(klg);
			}
			return klgl;
		}

}
