package com.tyan.ai.meaning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.knowledge.KnowledgeModel;
import com.tyan.ai.frame.memory.MemoryLink;
import com.tyan.ai.frame.memory.MemoryNode;
import com.tyan.ai.frame.memory.UnidirectionalLink;
import com.tyan.ai.frame.object.Entity;
import com.tyan.ai.frame.object.TyanObject;

public class MeaningModel {
	private boolean hasIntend = false;
	
	public Intend getIntend(){
		return intend;
	}

	public class Intend {
		private KnowledgeModel keyman;
		private List<String> modifieds;
		private String attribute;
		
		private List<KnowledgeModel> qwords = new ArrayList<KnowledgeModel>();
		// 先 确定seged 再大脑解析
		public Intend(List<KnowledgeModel> klgs, List<String> roles){
			for(int i=0; i<klgs.size(); i++){
				String role = roles.get(i);
				switch (role) {
				case "keyman":
					this.keyman = klgs.get(i);
					break;
				case "qword":
					this.qwords.add(klgs.get(i));
					break;
				default:
					break;
				}
			}
		}
		
		public KnowledgeModel getKeyman(){
			return keyman;
		}
		
		public void thinking(){
			
		}
		
		public void keymanFromContext(){
			this.keyman = activeSide;
		}

	}
	
	public boolean hasIntend(){
		return hasIntend;
	}
	
	//private boolean hasIntend = false;
	
	private boolean lock = false;
	
	private Intend intend;
	
	private EnableModel mmEnable;//小红去了一座山，enable负责抽象
	
	//seged -> judge !
	private KnowledgeModel activeSide;
	private KnowledgeModel bridge;
	private KnowledgeModel accepted;
	private KnowledgeModel apple;
	private HashMap<KnowledgeModel, KnowledgeModel> describe;

	public boolean input(KnowledgeModel klg ,String role){
		if(lock = true)
			return false;
		
		switch (role) {
		case "activeSide":
			this.activeSide = klg;
			break;
		case "bridge":
			this.bridge = klg;
			break;
		case "accepted":
			this.accepted = klg;
			break;

		default:
			break;
		}
		return true;
	}
	
	public void parseIntend(List<KnowledgeModel> klgs, List<String> roles){
		this.intend = new Intend(klgs, roles);
	}
	
	public void finished(){
		lock =true;
	}
	
	public MemoryNode generateAMNode(){
		TyanObject ao = new Entity(activeSide.getName());
		MemoryNode mn1 = new MemoryNode();
		
		TyanObject bo = new Entity(activeSide.getName());
		MemoryLink l1 = new UnidirectionalLink();
		l1.setLinkname(bridge.getName());
		
		TyanObject ao2 = new Entity(accepted.getName());
		MemoryNode mn2 = new MemoryNode();
		
		l1.setBeforeNode(mn1);
		l1.setAfterNode(mn2);
		
		return mn1;
	}
	
//	public MemoryNode generateAMNode(){
		
//	}
	
		
}
