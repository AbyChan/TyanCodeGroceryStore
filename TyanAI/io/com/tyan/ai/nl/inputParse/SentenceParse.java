package com.tyan.ai.nl.inputParse;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import org.lionsoul.jcseg.ASegment;
import org.lionsoul.jcseg.core.ADictionary;
import org.lionsoul.jcseg.core.DictionaryFactory;
import org.lionsoul.jcseg.core.IWord;
import org.lionsoul.jcseg.core.JcsegException;
import org.lionsoul.jcseg.core.JcsegTaskConfig;
import org.lionsoul.jcseg.core.SegmentFactory;


import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.Tree;

public class SentenceParse {
	/*JcsegTaskConfig config = new JcsegTaskConfig("bin/jcseg.properties");
	ADictionary dic = DictionaryFactory
			.createDefaultDictionary(config);
	ASegment seg;
	MaxentTagger tagger = new MaxentTagger("chinese-distsim.tagger");
	LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/chinesePCFG.ser.gz");
	
	
	public SentenceParse() {
		try {
			seg = (ASegment) SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE,
					new Object[]{config, dic});
		} catch (JcsegException e) {
			e.printStackTrace();
		}
	}*/
	
	
	
	public Tree getLexparser(String sentence) throws IOException{
		List<String> words = getSpiltWords(sentence);
		return getLexparser(words);
	}
	
	public Tree getLexparser(List<String> words){
		List<CoreLabel> rawWords = new ArrayList<CoreLabel>();
		for(String word : words){
			CoreLabel cword = new CoreLabel();
			cword.setWord(word);
			rawWords.add(cword);
		}
		Tree parse = NLTool.lp.apply(rawWords);
		return parse;
	}
	
	public List<String> getSpiltWords(String sentence) throws IOException{
		NLTool.seg.reset(new StringReader(sentence));
		List<String> words = new ArrayList<String>();
		IWord word = null;
		while ( (word = NLTool.seg.next()) != null ) {
			words.add(word.getValue());
		}
		return words;
	}
	
	public Entry<List<TaggedWord>, Tree> getParse(String sentence) throws IOException{
		List<String> words = getSpiltWords(sentence);
		List<TaggedWord> taggedWord = getPos(words);
		Tree lexparser = getLexparser(words);
		Entry<List<TaggedWord>, Tree> parse = new ParseEntry(taggedWord, lexparser);
		return parse;
	}
	

	
	public List<TaggedWord> getPos(String sentence) throws IOException{
		List<String> words = getSpiltWords(sentence);
		return getPos(words);
	}
	
	public List<TaggedWord> getPos(List<String> words) throws IOException{
		List<HasWord> sent = new ArrayList<HasWord>();
		for(String word : words){
			HasWord hword = new Word(word);
			sent.add(hword);
		}
		List<TaggedWord> taggedSent = NLTool.tagger.tagSentence(sent);
	    return taggedSent;
		
	}
	


}
