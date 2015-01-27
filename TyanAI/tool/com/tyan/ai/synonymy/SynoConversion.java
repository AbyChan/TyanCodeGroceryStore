package com.tyan.ai.synonymy;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lionsoul.jcseg.core.IWord;

import com.tyan.ai.nl.inputParse.NLTool;
import com.tyan.ai.nl.inputParse.SentenceParse;
import com.tyan.ai.tool.NLPTool;

import edu.stanford.nlp.ling.TaggedWord;

public class SynoConversion {
	private static HashMap<String, String> synoHM;
	static{
		synoHM = SynoTrain.getSynoHM();
	}
	
	public static String conversion(String word){
		if(synoHM.containsKey(word))
			return synoHM.get(word);
		return word;
	}
	
	public static String getSynoSentence(String sentence) throws IOException{
		List<String> words = NLPTool.getSpiltWords(sentence);
		String syn = "";
		for(String word : words)
			syn += conversion(word);
		return syn;
	}
	

}
