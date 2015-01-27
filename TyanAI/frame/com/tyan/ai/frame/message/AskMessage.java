package com.tyan.ai.frame.message;

import java.io.IOException;

import com.tyan.ai.synonymy.SynoConversion;
import com.tyan.ai.tool.HashTool;
import com.tyan.ai.tool.HibernateTool;
import com.tyan.ai.tool.nlp.NNVVFilter;

public class AskMessage extends Message {
	
	long synonymousHash;
	long fuzzyHash;
	
	public void setSynonymousHash(long synonymousHash) {
		this.synonymousHash = synonymousHash;
	}
	public void setFuzzyHash(long fuzzyHash) {
		this.fuzzyHash = fuzzyHash;
	}
	public long getSynonymousHash() {
		return synonymousHash;
	}
	public long getFuzzyHash() {
		return fuzzyHash;
	}
	
	public AskMessage(String sentence) throws IOException {
		super(sentence);
		String fuzzQT = NNVVFilter.getNNVV(sentence);
		String synQT = SynoConversion.getSynoSentence(fuzzQT);
		this.synonymousHash = HashTool.BKDRHash(synQT);
		this.fuzzyHash = HashTool.BKDRHash(fuzzQT);
	}
	
	public AskMessage() {
	}

	
	public static void main(String[] args) throws IOException {
		//test
		AskMessage am = new AskMessage("哈哈哈哈吃屎");
		HibernateTool.save(am);
	}

}
