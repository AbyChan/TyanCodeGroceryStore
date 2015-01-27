package com.tyan.ai.frame.enabler;

public class EnableModel {
	private String name;

	private Enabler enabler;
	// private Relation relation;
	private Rule rule;

	public EnableModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Enabler getEnabler() {
		return enabler;
	}

	public void setEnabler(Enabler enabler) {
		this.enabler = enabler;
	}
	/*
	 * public Relation getRelation() { return relation; } public void
	 * setRelation(Relation relation) { this.relation = relation; }
	 */

}
