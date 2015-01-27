package com.tyan.ai.frame.filter;

public class PreSetFilter {
	
	public static boolean isSetQuestion(String sentence){
		if( sentence.startsWith("@") )
			return true;
		else
			return false;
	}

}
