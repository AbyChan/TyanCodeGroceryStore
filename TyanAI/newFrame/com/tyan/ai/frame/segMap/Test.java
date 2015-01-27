package com.tyan.ai.frame.segMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.tyan.ai.nl.inputParse.SentenceParse;

import edu.stanford.nlp.ling.TaggedWord;

public class Test {
	public static void main(String[] args) throws IOException {
		
		
		String sentence1 = "森林里面的树好大";
		String sentence2 = "森林没有树";
		String sentence3 = "森林里面的树都高";
		String sentence4 = "鸡巴好大";
		
		MapNet.input(makeInput(sentence1));
		MapNet.input(makeInput(sentence2));
		MapNet.input(makeInput(sentence3));
		MapNet.input(makeInput(sentence4));
		MapNet.show();
	}
	
	public static List<Entry<String, String>> makeInput(String sentence) throws IOException{
		List<Entry<String, String>> input = new ArrayList<Entry<String, String>>();
		SentenceParse sp = new SentenceParse();
		List<TaggedWord> tw = sp.getPos(sentence);
		for(TaggedWord etw : tw ){
			Entry<String, String> ew = new InputEntry(etw.word() , etw.tag());
			input.add(ew);
		}
		return input;
	}
}
