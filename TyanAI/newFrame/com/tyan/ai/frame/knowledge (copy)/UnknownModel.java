package com.tyan.ai.frame.knowledge;

import com.tyan.ai.frame.enabler.EnableModel;
import com.tyan.ai.frame.logic.LogicModel;
import com.tyan.ai.frame.logic.LogicalUnit;

public class UnknownModel extends KnowledgeModel {

	public UnknownModel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	private void UnkwonProcess(){
		//联想处理
	}

	@Override
	public void addAttribute(String key, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public LogicModel getLogic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnableModel getEnablerModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogic(LogicModel lmodel) {
		// TODO Auto-generated method stub
		
	}

}
