package com.tyan.ai.frame.segMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class TeachInput {
	
	public TeachInput() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Entry<String, String>> teach(String tinput){
		List<Entry<String, String>> input = new ArrayList<Entry<String, String>>();
		String[] cells = tinput.split(" ");
		if( (cells.length % 2) != 0){
			System.out.println("Error Input");
		}else if( (cells.length % 2) == 0){
			for(int i = 0; i<cells.length; i++){
				String word = cells[i];
				String tag = cells[++i];
				Entry<String, String> ew = new InputEntry(word, tag);
				input.add(ew);
			}
		}
		return input;
	}

}
