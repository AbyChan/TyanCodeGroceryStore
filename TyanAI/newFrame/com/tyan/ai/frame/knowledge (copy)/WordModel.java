package com.tyan.ai.frame.knowledge;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.logic.LogicModel;
import com.tyan.ai.frame.logic.LogicalUnit;

@SuppressWarnings("serial")
public class WordModel extends KnowledgeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3475548495034643506L;
	private String pingyin;//not used
	
	public WordModel(String name) {
		super(name);
	}

	@Override
	public void addAttribute(String key, String value) {
		super.attribute.put(key, value);
	}



	@Override
	public EnableModel getEnablerModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicModel getLogic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogic(LogicModel lmodel) {
		System.out.println("this class not have lmodel");
	}


}
