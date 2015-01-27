package com.tyan.ai.nl.inputParse;

import java.util.List;
import java.util.Map.Entry;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.Tree;

public class ParseEntry implements Entry<List<TaggedWord>, Tree> {
	private List<TaggedWord> taggedWord;
	private Tree lexparser;
	
	public ParseEntry(List<TaggedWord> taggedWord, Tree lexparser) {
		this.taggedWord = taggedWord;
		this.lexparser = lexparser;
	}
	

	@Override
	public List<TaggedWord> getKey() {
		return taggedWord;
	}

	@Override
	public Tree getValue() {
		return lexparser;
	}

	@Override
	public Tree setValue(Tree lexparser) {
		Tree old = this.lexparser;
        this.lexparser = lexparser;
        return old;
	}

}
