package com.tyan.ai.frame.memory;

import java.util.ArrayList;
import java.util.List;

import com.tyan.ai.frame.object.TyanObject;

public class MemoryNode {
	
	private TyanObject object;
	private List<MemoryLink> beforelink;
	private List<MemoryLink> afterlink;
	
	
	
	public List<MemoryLink> getBeforelink() {
		return beforelink;
	}
	public void setBeforelink(List<MemoryLink> beforelink) {
		this.beforelink = beforelink;
	}
	public List<MemoryLink> getAfterlink() {
		return afterlink;
	}
	public void setAfterlink(List<MemoryLink> afterlink) {
		this.afterlink = afterlink;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		if(this.object.equals(((MemoryNode) obj).getObject()))
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		return this.getClass().hashCode() + 17 * this.object.getClass().hashCode();
	}
	
	
	public TyanObject getObject() {
		return object;
	}
	public void setObject(TyanObject object) {
		this.object = object;
	}
	
	
	public boolean addBeforeLink(MemoryLink bLink){
		if(beforelink == null){
			beforelink = new ArrayList<MemoryLink>();
		}
		if(beforelink.contains(bLink))
			return false;
		else{
			beforelink.add(bLink);
			bLink.setAfterNode(this);
			return true;
			}
		
	}
	
	public boolean addAfterLink(MemoryLink aLink){
		if(afterlink == null){
			afterlink = new ArrayList<MemoryLink>();
		}
		if(afterlink.contains(aLink))
			return false;
		else{
			afterlink.add(aLink);
			aLink.setAfterNode(this);
			return true;
			}
	}
	
	
}
