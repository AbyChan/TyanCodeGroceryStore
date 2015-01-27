package com.tyan.ai.frame.memory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class MemoryMap {
	private HashMap<String, MemoryNode> memoryEntrance;
	//!!!! 重写String ， 一个String 可以多指向
	
	public MemoryMap() {
		memoryEntrance = new HashMap<String, MemoryNode>();
	}

	public HashMap<String, MemoryNode> getMemoryEntrance() {
		return memoryEntrance;
	}
	
	public MemoryNode search(String name){
		return memoryEntrance.get(name);
	}

	//插入一条
	public void putMemoryNode(MemoryNode node) {
		MNIterator outIterator = new MNIterator(node);
		List<MemoryNode> outAllNode = outIterator.getAllNode();
		LinkedHashMap<MemoryNode, MemoryNode> prepareEmbed = new LinkedHashMap<MemoryNode, MemoryNode>();
		for (MemoryNode erootNode : memoryEntrance.values()) {
			MNIterator inIterator = new MNIterator(erootNode);
			while(inIterator.hasNext()){
				MemoryNode contrastNode = inIterator.getNext();
				for(MemoryNode ocNode : outAllNode){
					if(contrastNode.equals(ocNode)){
						prepareEmbed.put(ocNode, contrastNode);
					}
				}
			}
		}
		for(MemoryNode keynode : prepareEmbed.keySet()){
			nodeEmbed(keynode, prepareEmbed.get(keynode));
		}
	}
	
	
	//插入
	public void nodeEmbed(MemoryNode outNode, MemoryNode inNode){
		for(MemoryLink oal : outNode.getAfterlink()){
			oal.setBeforeNode(inNode);
		}
		for(MemoryLink obl : outNode.getBeforelink()){
			obl.setAfterNode(inNode);
		}
	}
	
	//更新各入口，可能几条会合并成一条
	public void Merge(){
		for(String entranceName : memoryEntrance.keySet()){
			MemoryNode rootNode = memoryEntrance.get(entranceName);
			
		}
	}

}
