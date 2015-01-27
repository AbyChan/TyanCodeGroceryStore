package com.tyan.ai.frame.match;

import com.tyan.ai.frame.Knowledge.ZhidaoKnowledge;
import com.tyan.ai.frame.context.ContextInfo;
import com.tyan.ai.frame.message.AnsterMessage;
import com.tyan.ai.frame.message.AskMessage;
import com.tyan.ai.frame.message.Message;

public abstract class Match {
	protected AskMessage msg;
	protected boolean ismatch = false;
	protected AnsterMessage anster;
	
	public boolean match(){
		return ismatch;
	}
	
	public AnsterMessage anster(){
		if(ismatch == true)
			return anster;
		return null;
	}
	
	protected AnsterMessage chooseAnster(ZhidaoKnowledge klg, ContextInfo ci){
		AnsterMessage am = null;
		if(klg.getBestAnster() != null && !klg.getBestAnster().equals("null") )
			 am = new AnsterMessage(klg.getBestAnster());
		if(klg.getSimpleAnster() != null && !klg.getSimpleAnster().equals("null") )
			 am = new AnsterMessage(klg.getSimpleAnster());
		if(klg.getSimpleAnster2() != null && !klg.getSimpleAnster2().equals("null") )
			 am = new AnsterMessage(klg.getSimpleAnster2());
		if(klg.getSimpleAnster3() != null && !klg.getSimpleAnster3().equals("null") )
			 am = new AnsterMessage(klg.getSimpleAnster3());
		return am;
	}

}
