package com.tyan.ai.frame.enabler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EnablerMaker {
	
	public static void input(EnablerMakeMaterial emm){
		
	}
	
	public static void InitteachInput() throws IOException{
		File file = new File("newFrame/com/tyan/ai/enabler/EnablerTeachInput");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line != null){
			String ruleLine = br.readLine();
			if(ruleLine == null)
				System.out.println("teachInput error!!!!!!");
			makeEnaber(line, ruleLine);
			line = br.readLine();
		}
		br.close();
	}
	
	public static void makeEnaber(String line, String ruleLine){
		Enabler eb = new Enabler();
		String[] inputs = line.split(" ");
		String[] ruleInputs = ruleLine.split(" ");
		String name = inputs[0];
		for(int i=1; i<inputs.length-1; i++){
			String[] vs = null;
			String[] kv = inputs[i].split(":");
			if(kv[1].split(">").length > 1)
				vs = kv[1].split(">");
			else
				vs[0] = kv[1];
			for(String v : vs){
				eb.stateTransition(kv[0], v);
			}
		}
		
		Rule rule = new Rule();
		for(String erule : ruleInputs){
			String[] kv = erule.split(":");
			switch (kv[0]) {
			case "AB":
				rule.setAB(kv[1]);
				break;
			case "invalid":
				String[] vs = kv[1].split(",");
				rule.setInvalid(vs);
			default:
				System.out.println("rule input error!!!!!!!!!!!!!!!!!!!!");
			}
		}
		EnableModel em = new EnableModel(name);
		em.setEnabler(eb);
		em.setRule(rule);
	}
	
	

}
