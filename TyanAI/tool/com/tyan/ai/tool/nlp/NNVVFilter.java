package com.tyan.ai.tool.nlp;

import java.io.IOException;
import java.util.List;

import com.tyan.ai.nl.inputParse.SentenceParse;

import edu.stanford.nlp.ling.TaggedWord;

public class NNVVFilter {

	public static String getNNVV(String sentence) throws IOException{

		SentenceParse sp = new SentenceParse();
		List<TaggedWord> ls = sp.getPos(sentence);
		String ns = "";
		for (TaggedWord tw : ls){
			if(tw.tag().equals("NN")||tw.tag().equals("VV")||tw.tag().equals("NR")||tw.tag().equals("VC")||tw.tag().equals("PN")||tw.tag().equals("VA"))
				ns = ns+tw.word();
		}
		for (TaggedWord tw : ls){
			System.out.println(tw.word());
			System.out.println(tw.tag());
		}
		return ns;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		System.out.println(getNNVV("继《关于系统的问题》"));
	}
}
