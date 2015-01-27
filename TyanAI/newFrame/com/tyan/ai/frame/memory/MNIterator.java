package com.tyan.ai.frame.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ub
 *深度优先+回溯
 */
public class MNIterator {
	private MemoryNode rootNode;
	
	private MemoryNode currentNode;
	
	private Stack<MemoryNode> marks;
	
	private List<MemoryLink> markMap;
	
	
	
	public MNIterator(MemoryNode rootNode) {
		this.rootNode = rootNode;
		currentNode = rootNode;
		markMap = new ArrayList<MemoryLink>();
		marks = new Stack<MemoryNode>();
	}
	
	public boolean hasNext(){
		if(currentNode != null)
			return true;
		else
			return false;
	}
	
	public MemoryNode getNext() {
		if (currentNode == null)
			return null;
		MemoryNode returnNode = currentNode;

		if (currentNode.getAfterlink() == null
				&& currentNode.getBeforelink() == null) {
			if (!marks.isEmpty())
				currentNode = marks.pop();
			else
				currentNode = null;

		} else if (currentNode.getAfterlink().size() >= 1) { // same logic
			if (currentNode.getAfterlink().size() > 1)
				marks.push(currentNode);
			List<MemoryLink> alinks = currentNode.getAfterlink();
			for (MemoryLink link : alinks) {
				if (markMap.contains(link))
					continue;
				else {
					markMap.add(link);
					currentNode = link.afterNode;
				}
			}

		} else if (currentNode.getBeforelink().size() >= 1) { // same logic
			if (currentNode.getBeforelink().size() > 1)
				marks.push(currentNode);
			List<MemoryLink> blinks = currentNode.getBeforelink();
			for (MemoryLink link : blinks) {
				if (markMap.contains(link))
					continue;
				else {
					markMap.add(link);
					currentNode = link.afterNode;
				}
			}
		} else
			System.out.println("In " + getClass().toString()
					+ " what the fuck error?");
		return returnNode;
	}
	
	public List<MemoryNode> getAllNode(){
		List<MemoryNode> allNode = new ArrayList<MemoryNode>();
		while(hasNext()){
			allNode.add(getNext());
		}
		return allNode;
	}
}
