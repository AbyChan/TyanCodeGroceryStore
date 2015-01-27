package com.tyan.ai.nl.inputParse;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.Tree;

public class CachePool {
	public static Entry<List<TaggedWord>, Tree>  parse;
	public static String paragraph;
	
	public static void Parse(String paragraph) throws IOException{
		CachePool.paragraph = paragraph;
		parse = null;
		SentenceParse sp = new SentenceParse();
		parse = sp.getParse(paragraph);
	}

}
