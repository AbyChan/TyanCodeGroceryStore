package com.tyan.ai.frame.memory;

import com.tyan.ai.frame.logic.LogicalUnit;

/**
 * @author ub
 * 单向Link
 *
 */
public class UnidirectionalLink extends MemoryLink {
	//private String linkname;
	//private LogicalUnit logic;
	private Relation relation;
	
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getRoleName() {
		return linkname;
	}
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	public void setRoleName(String linkname) {
		this.linkname = linkname;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		if(this.linkname.equals(((UnidirectionalLink) obj).getRoleName()) 
				&& this.relation == ((UnidirectionalLink) obj).getRelation()
				&& getBeforeNode().equals(((UnidirectionalLink) obj).getBeforeNode())
				&& getAfterNode().equals(((UnidirectionalLink) obj).getAfterNode())
				)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode() + 13 * this.linkname.hashCode();
	}
	
	@Override
	public MemoryNode getBeforeNode() {
		return super.beforeNode;
	}
	@Override
	public MemoryNode getAfterNode() {
		return super.afterNode;
	}
	
	
}
