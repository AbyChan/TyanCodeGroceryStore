package com.tyan.ai.frame.heart;

import java.util.ArrayList;
import java.util.List;

public class Resolver {
	
	public static List<String> getWords(String input){
		List<String> words = new ArrayList<String>();
		for(int i=0; i<input.length(); i++){
			String word = String.valueOf(input.charAt(i));
			words.add(word);
		}
		return words;
	}

}
