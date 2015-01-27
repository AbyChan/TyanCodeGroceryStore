package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tyan.ai.nl.inputParse.SentenceParse;
import com.tyan.ai.synonymy.SynoConversion;
import com.tyan.ai.tool.HashTool;

import edu.stanford.nlp.ling.TaggedWord;

public class FuzzSentenceTest {
	public long test1(String sentence){
		long x = HashTool.BKDRHash(sentence);
		return x;
	}
	
	public static void main(String[] args) throws IOException {
		FuzzSentenceTest xx = new FuzzSentenceTest();
		String st = "我的豪杰超级解霸怎么不能播放电影";
		System.out.println(xx.test1("我的豪杰超级解霸怎么不能播放电影"));
		SentenceParse x2 = new SentenceParse();
		List<TaggedWord> ls = x2.getPos(st);
		String ns = "";
		for (TaggedWord tw : ls){
			if(tw.tag().equals("NN")||tw.tag().equals("VV")){
				ns = ns+SynoConversion.conversion(tw.word());
				}
		}
//		for (TaggedWord tw : ls){
//			System.out.println(tw.word());
//			System.out.println(tw.tag());
//		}
		System.out.println(ns);
	}
}
