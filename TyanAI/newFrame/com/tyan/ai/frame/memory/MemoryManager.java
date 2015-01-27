package com.tyan.ai.frame.memory;

public class MemoryManager {
	private MemoryMap memorymap;
	
	public MemoryManager(MemoryMap memorymap) {
		this.memorymap = memorymap;
	}
	
	public void putToMemory(MemoryNode node) {
		memorymap.putMemoryNode(node);
	}
	
	public void reArrange(){
		memorymap.Merge();
	}
	
	public MemoryNode search(String name){
		return memorymap.search(name);
	}
}
