package com.tyan.ai.frame.knowledge;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.logic.LogicModel;
import com.tyan.ai.frame.logic.LogicalUnit;
import com.tyan.ai.frame.memory.MemoryMap;

public class BasicKlg extends KnowledgeModel {
	
/*	private enum PeopleTpye{
		entity,virtual
	}*/
	
//	private PeopleTpye tpye;
	
/*	private String[] where;
	private String[] character;
	private String[] description;*/
	
	/**
	 * 
	 */
	
	private LogicModel lmodel;
	
	public LogicModel getLmodel() {
		return lmodel;
	}

	public void setLmodel(LogicModel lmodel) {
		this.lmodel = lmodel;
	}

	private static final long serialVersionUID = -6233577070830843782L;
	private MemoryMap memoryMap;
	
	
	
	public BasicKlg(String name) {
		super(name);
	}
	
	@Override
	public void addAttribute(String key, String value) {
		super.attribute.put(key, value);
	}

	@Override
	public LogicModel getLogic() {
		return lmodel;
	}

	@Override
	public EnableModel getEnablerModel() {
		return null;
	}

	@Override
	public void setLogic(LogicModel lmodel) {
		// TODO Auto-generated method stub
		
	}

	

}
