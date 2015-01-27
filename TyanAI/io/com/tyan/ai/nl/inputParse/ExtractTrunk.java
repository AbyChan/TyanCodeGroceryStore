package com.tyan.ai.nl.inputParse;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.org.apache.bcel.internal.generic.LXOR;
import com.tyan.ai.json.Json;
import com.tyan.ai.json.JsonArray;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.trees.GrammaticalRelation;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeGraphNode;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.international.pennchinese.ChineseTreebankLanguagePack;

public class ExtractTrunk {

	public void getTrunk(Entry<List<TaggedWord>, Tree> parsedSentence){
		List<TaggedWord> taggedWord = parsedSentence.getKey();
		Tree lexparser = parsedSentence.getValue();
	//	Collection tdl = getDepenCollection(lexparser);
//		System.out.println(tdl);
		//System.out.println(lexparser.value());
		lexparser.pennPrint();
		Json test = tranJson(lexparser.children(),lexparser.value());
	//	System.out.println(test);
	//	tranJson();
		Json testx = getDepenJson(lexparser);
		System.out.println(testx);
		

	}
	
	public Json tranJson(Tree[] trees, String name){
		Json root = new Json();
		JsonArray set = new JsonArray();
		for(Tree tree : trees){
			if(tree.firstChild().isLeaf()){
				Json leaf = new Json();
			//	System.out.println(tree.value());
			//	System.out.println(tree.getLeaves().toString());
				leaf.put(tree.value(), tree.getLeaves().toString());
				set.put(leaf);
			}else{
			//	System.out.println(tree.value());
				set.put(tranJson(tree.children(),tree.value()));
			}
		}
		root.put(name, set);
		return root;
	}
	
/*	public Entry<String, Object> getFuck(Tree[] trees, String name){
		//Entry<String, Object> root = new NLEntry();
		NLEntry[] set = new NLEntry();
		for(Tree tree : trees){
			if(tree.firstChild().isLeaf()){
				Json leaf = new Json();
			//	System.out.println(tree.value());
			//	System.out.println(tree.getLeaves().toString());
				leaf.put(tree.value(), tree.getLeaves().toString());
				set.put(leaf);
			}else{
			//	System.out.println(tree.value());
				set.put(tranJson(tree.children(),tree.value()));
			}
		}
		root.put(name, set);
		return root;
		
	}*/
	
	/*public Map<String, Object> getMap(Tree[] trees, String name){
		HashMap<String, Object> root = new HashMap<String, Object>();
		HashMap<String, Object> set[] = new HashMap<String, Object>();
		for(Tree tree : trees){
			
			if(tree.firstChild().isLeaf()){
				Map<String, Object> leaf = new HashMap<String, Object>();
			//	System.out.println(tree.value());
			//	System.out.println(tree.getLeaves().toString());
				leaf.put(tree.value(), tree.getLeaves().toString());
				set.put(leaf);
			}else{
			//	System.out.println(tree.value());
				set.put(tranJson(tree.children(),tree.value()));
			}
		}
		root.put(name, set);
		return root;
	}*/
	
	public Json getDepenJson(Tree parse){
		TreebankLanguagePack tlp = new ChineseTreebankLanguagePack();
	    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
	    GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
	    Collection tdl = gs.typedDependenciesCCprocessed();
	    
	    Json depen = new Json();
	    JsonArray set = new JsonArray();
		for (int i = 0; i < tdl.size(); i++) {
			TypedDependency td = (TypedDependency) tdl.toArray()[i];
			TreeGraphNode dep = td.dep();
			TreeGraphNode gov = td.gov();
			GrammaticalRelation reln = td.reln();
			Json depj = new Json();
			depj.put(dep.value(), dep.index() + "");
			Json govj = new Json();
			govj.put(gov.value(), gov.index() + "");
			JsonArray deset = new JsonArray();
			deset.put(depj);
			deset.put(govj);
			Json cell = new Json();
			cell.put(reln.toString(), deset);
			set.put(cell);
		}
		depen.put("depen", set);
		return depen;
	}
	
	public Collection getDepenCollection(Tree parse){
		TreebankLanguagePack tlp = new ChineseTreebankLanguagePack();
	    GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory();
	    GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
	    Collection tdl = gs.typedDependenciesCCprocessed();
	    return tdl;
	}
	
	public static void main(String[] args) throws IOException {
		SentenceParse test = new SentenceParse();

		String sentence = "小渔慢慢说：「一个病人，快死的。他喜欢了我一年多。」";

		Entry<List<TaggedWord>, Tree> parse = test.getParse(sentence);
		ExtractTrunk xxt = new ExtractTrunk();
		xxt.getTrunk(parse);
	}
}
