package com.tyan.ai.frame.Knowledge;

public class ZhidaoKnowledge {
	String question;
	long qstHash;
	long qstSynHash;
	long qstFuzzyHash;
	String bestAnster;
	String simpleAnster;
	String simpleAnster2;
	String simpleAnster3;
	String smartAnster;
	
	public ZhidaoKnowledge() {
		// TODO Auto-generated constructor stub
	}
	
	public ZhidaoKnowledge(String question, long qstHash, long qstSynHash,
			long qstFuzzyHash, String bestAnster, String simpleAnster,
			String simpleAnster2, String simpleAnster3, String smartAnster) {
		super();
		this.question = question;
		this.qstHash = qstHash;
		this.qstSynHash = qstSynHash;
		this.qstFuzzyHash = qstFuzzyHash;
		this.bestAnster = bestAnster;
		this.simpleAnster = simpleAnster;
		this.simpleAnster2 = simpleAnster2;
		this.simpleAnster3 = simpleAnster3;
		this.smartAnster = smartAnster;
	}
	public String getSimpleAnster2() {
		return simpleAnster2;
	}
	public void setSimpleAnster2(String simpleAnster2) {
		this.simpleAnster2 = simpleAnster2;
	}
	public String getSimpleAnster3() {
		return simpleAnster3;
	}
	public void setSimpleAnster3(String simpleAnster3) {
		this.simpleAnster3 = simpleAnster3;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public long getQstHash() {
		return qstHash;
	}
	public void setQstHash(long qstHash) {
		this.qstHash = qstHash;
	}
	public long getQstSynHash() {
		return qstSynHash;
	}
	public void setQstSynHash(long qstSynHash) {
		this.qstSynHash = qstSynHash;
	}
	public long getQstFuzzyHash() {
		return qstFuzzyHash;
	}
	public void setQstFuzzyHash(long qstFuzzyHash) {
		this.qstFuzzyHash = qstFuzzyHash;
	}
	public String getBestAnster() {
		return bestAnster;
	}
	public void setBestAnster(String bestAnster) {
		this.bestAnster = bestAnster;
	}
	public String getSimpleAnster() {
		return simpleAnster;
	}
	public void setSimpleAnster(String simpleAnster) {
		this.simpleAnster = simpleAnster;
	}
	public String getSmartAnster() {
		return smartAnster;
	}
	public void setSmartAnster(String smartAnster) {
		this.smartAnster = smartAnster;
	}
}
