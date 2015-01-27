package com.tyan.ai.frame.segMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seger {

	//unfinished
	public static List<String> getSeg(String sentence){
		return null;
	}
	
	public static List<String> getSegFake(String sentence){
		String[] segs = sentence.split(" ");
		List<String> seged = Arrays.asList(segs);
		return seged;
	}
	
	
	//public static List<String>
	
	public static List<WaR> getWRFake(String sentence){
		List<WaR> wrs = new ArrayList<WaR>();
		String[] segs = sentence.split(" ");
		for(String seg : segs){
			String word = seg.split(":")[0];
			String role = seg.split(":")[1];
			WaR wr = new WaR(word, role);
			wrs.add(wr);
		}
		return wrs;
	}
	
	public static List<String> getAllWord(List<WaR> wrs){
		List<String> words = new ArrayList<String>();
		for(WaR wr :wrs){
			words.add(wr.getWord());
		}
		return words;
	}
	public static List<String> getAllRole(List<WaR> wrs){
		List<String> roles = new ArrayList<String>();
		for(WaR wr :wrs){
			roles.add(wr.getRole());
		}
		return roles;
	}
}
