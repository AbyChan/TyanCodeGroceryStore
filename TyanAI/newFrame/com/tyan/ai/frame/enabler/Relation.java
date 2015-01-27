/*package com.tyan.ai.frame.enabler;

import com.tyan.ai.frame.rule.Rule;

public class Relation {
	private String active;
	private String passive;
	
	private String action;
	
	private Rule rule;
	
	

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != this.getClass())
			return false;
		if(this.active.equals(((Relation)obj).getActive() )
				&& this.passive.equals(((Relation)obj).getPassive())
				&& this.action.equals(((Relation)obj).getAction())
				&& this.rule.equals(((Relation)obj).getRule()))
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return active.hashCode() + passive.hashCode() + action.hashCode() + rule.getName().hashCode();
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getPassive() {
		return passive;
	}
	public void setPassive(String passive) {
		this.passive = passive;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
*/