package com.tyan.ai.frame.segMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.tyan.ai.tool.HashTool;

public class SMNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String word;
	private String tag;
	
	private List<SMNode> nexts;
	private List<SMNode> lasts;
	
	public int getNextsSize(){
		return nexts.size();
	}
	
	public int getLasttsSize(){
		return lasts.size();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return false;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return (((SMNode) obj).getWord().equals(this.word) && ((SMNode) obj)
					.getTag().equals(this.tag));
	}
	
	@Override
	public int hashCode() {
		return (int) HashTool.BKDRHash(word + tag);
	}
	
	public List<SMNode> getNexts(){
		return nexts;
	}
	
	public List<SMNode> getLasts(){
		return lasts;
	}
	
	public SMNode(String word, String tag) {
		this.word = word;
		this.tag = tag;
		nexts = new ArrayList<SMNode>();
	}
	
	public SMNode(String word) {
		this.word = word;
		this.tag = null;
	}
	
	public void addNext(SMNode next){
		if(nexts == null)
			nexts = new ArrayList<SMNode>();
		nexts.add(next);
		next.addLast(this);
	}
	
	public void addLast(SMNode last){
		if(lasts == null)
			lasts = new ArrayList<SMNode>();
		lasts.add(last);
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	public void show(){
		if(nexts.size() != 0)
			System.out.println(word + ":" + tag + "--->");
		else
			System.out.println(word + ":" + tag);
		for(SMNode sn : nexts){
			sn.show();
		}
	}
}
