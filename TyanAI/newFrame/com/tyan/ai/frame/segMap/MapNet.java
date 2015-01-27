package com.tyan.ai.frame.segMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class MapNet {
	private static List<SMNode> fwEntrance = new LinkedList<SMNode>();
	
	public static void show(){
		for( SMNode eNode : fwEntrance ){
			eNode.show();
			System.out.println("----------------------------------------------------------");
		}
	}

	
	public static void process(List<SMNode> inputNode) {
		SMNode first = inputNode.get(0);
		if (fwEntrance.contains(first)) {
			int index = fwEntrance.indexOf(first);
			inputNode.remove(0);
			subProcess(fwEntrance.get(index), inputNode);
		} else {
			fwEntrance.add(first);
			inputNode.remove(0);
			subProcess(first, inputNode);
		}
	}
	
	public static void input(String[] input){
		List<SMNode> inputNode = new ArrayList<SMNode>();
		for(String word : input){
			SMNode node = new SMNode(word);
			inputNode.add(node);
		}
		process(inputNode);
	}
	
	public static void input(List<Entry<String, String>> input){
		List<SMNode> inputNode = new ArrayList<SMNode>();
		for(Entry<String, String> cell : input){
			SMNode node = new SMNode(cell.getKey(), cell.getValue());
			inputNode.add(node);
		}
		process(inputNode);
	}
	
	/*迭代函数*/
	private static void subProcess(SMNode ln, List<SMNode> remain) {
		List<SMNode> nexts = ln.getNexts();
		if (remain.size() != 0) {
			SMNode first = remain.get(0);
			boolean mark = false;
			int mi = 0;
			for (SMNode next : nexts) {
				if (next.equals(first)) {
					mark = true;
					break;
				}
				mi++;
			}
			if (mark == true) {
				SMNode noded = nexts.get(mi);
				remain.remove(0);
				subProcess(noded, remain);
			} else {
				ln.addNext(first);
				remain.remove(0);
				subProcess(first, remain);
			}
		}
	}

}
