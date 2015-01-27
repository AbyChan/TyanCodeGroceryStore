package com.tyan.ai.tool;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.lionsoul.jcseg.core.IWord;

import com.tyan.ai.nl.inputParse.NLTool;

public class NLPTool {
	public static List<String> getSpiltWords(String sentence) throws IOException{
		NLTool.seg.reset(new StringReader(sentence));
		List<String> words = new ArrayList<String>();
		IWord word = null;
		while ( (word = NLTool.seg.next()) != null ) {
			words.add(word.getValue());
		}
		return words;
	}
}
