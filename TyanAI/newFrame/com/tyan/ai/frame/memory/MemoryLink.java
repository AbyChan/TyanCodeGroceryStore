package com.tyan.ai.frame.memory;

public abstract class MemoryLink {
	protected MemoryNode beforeNode;
	protected MemoryNode afterNode;
	protected String linkname;
	
	

	public String getLinkname() {
		return linkname;
	}
	abstract public boolean equals(Object obj);
	abstract public int hashCode();
	
	abstract public MemoryNode getBeforeNode();
	abstract public MemoryNode getAfterNode();
	
	public void setBeforeNode(MemoryNode beforeNode) {
		this.beforeNode = beforeNode;
	}
	
	public void setAfterNode(MemoryNode afterNode) {
		this.afterNode = afterNode;
	}
	public void setLinkname(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
